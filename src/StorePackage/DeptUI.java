package StorePackage;

import com.alee.extended.window.WebPopOver;
import com.alee.laf.WebLookAndFeel;
import com.alee.managers.notification.NotificationManager;
import com.alee.managers.notification.WebNotificationPopup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MahmoodKhalid
 */
public class DeptUI extends javax.swing.JFrame {
    
    private int CurDeptartmentID = 5;// this variable is to be determined from the main UI
    private int curUserID;
    EntityManagerFactory emf = null;
    EntityManager em = null;
    DefaultTableModel model;
    DefaultTableModel model2;
    DefaultTableModel model3;
    DefaultTableModel model4;
    ResultSet rs;
    Vector v;
    Vector v2;
    Vector v3;
    List<Items> allItems;
    List<RequestOfItems> allrequests;
    List<DeliveryForm> alldeliveries;
    List<RequestOfItems> deptrequests;
    Vector<DeliveryForm> dfv;


    public DeptUI(int CurDeptartmentID, int curUserID) {
        this.CurDeptartmentID = CurDeptartmentID;
        this.curUserID = curUserID;
        initComponents();
        
        Message = new JLabel();
        pop = new WebPopOver(this);
        pop.setCloseOnFocusLoss(true);
        pop.add(Message);
        pop.setMargin(15);
        Message.addPropertyChangeListener("text", new PropertyChangeListener() {
            
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                pop.show(DeptUI.this);
            }
        });
        
        emf = Persistence.createEntityManagerFactory("AZMprojectPU");
        em = emf.createEntityManager();
        
        String deptName = ((Departments) em.createNamedQuery("Departments.findByDeptId")
                .setParameter("deptId", CurDeptartmentID)
                .getSingleResult()).getDeptName();
        setTitle(deptName + " Items Managing");
        
        model = (DefaultTableModel) ItemsTable.getModel();
        model2 = (DefaultTableModel) ItemsTable2.getModel();
        model3 = (DefaultTableModel) ItemsTable3.getModel();
        model4 = (DefaultTableModel) pendingItemsTable.getModel();
        
        EditQuantity.setEnabled(false);
        DeleteRequestedItem.setEnabled(false);
        DeleteRequest.setEnabled(false);

        dfv = (Vector<DeliveryForm>) em.createNamedQuery("DeliveryForm.findConfirmedByDeptId")
                .setParameter("confirmed", 'N')
                .setParameter("deptId", CurDeptartmentID)
                .getResultList();

        // create Notification
        WebNotificationPopup notif = NotificationManager.showNotification(this, "" + (dfv.size() > 0 ? dfv.size() : "No") + " new deliveries issued.");
        notif.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(dfv.size() > 0)
                    DeptPane.setSelectedIndex(2);
            }
        });
        notif.setDisplayTime(4000);
        em = null;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    emf.close();
                } catch (NullPointerException ex) {                    
                }
            }
            
        });
        
        DeptPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateState();
            }
        });
        updateState();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DeptPane = new javax.swing.JTabbedPane();
        OrderTab = new javax.swing.JPanel();
        OrderItems = new javax.swing.JButton();
        AddItem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ItemsTable = new javax.swing.JTable();
        DeleteItem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ItemsList = new javax.swing.JList();
        ManageReqestsTab = new javax.swing.JPanel();
        EditQuantity = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ItemsTable2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        RequestsList = new javax.swing.JList();
        DeleteRequestedItem = new javax.swing.JButton();
        DeleteRequest = new javax.swing.JButton();
        DeliveriesTab = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ItemsTable3 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        DeliveriesList = new javax.swing.JList();
        confirmAll = new javax.swing.JButton();
        confirmSelected = new javax.swing.JButton();
        PendingItemsTab = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        pendingItemsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/StorePackage/zakat.jpg")).getImage());
        setResizable(false);

        OrderItems.setText("Order Items");
        OrderItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderItemsActionPerformed(evt);
            }
        });

        AddItem.setText("Add Item");
        AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemActionPerformed(evt);
            }
        });

        ItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Selected Items", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ItemsTable);

        DeleteItem.setText("Delete Item");
        DeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteItemActionPerformed(evt);
            }
        });

        ItemsList.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Items Available"))));
        ItemsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(ItemsList);

        javax.swing.GroupLayout OrderTabLayout = new javax.swing.GroupLayout(OrderTab);
        OrderTab.setLayout(OrderTabLayout);
        OrderTabLayout.setHorizontalGroup(
            OrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderTabLayout.createSequentialGroup()
                .addGroup(OrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(OrderItems))
                    .addGroup(OrderTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(OrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                            .addGroup(OrderTabLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(OrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(AddItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DeleteItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        OrderTabLayout.setVerticalGroup(
            OrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OrderTabLayout.createSequentialGroup()
                        .addComponent(AddItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteItem))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OrderItems)
                .addContainerGap())
        );

        DeptPane.addTab("Order", OrderTab);

        EditQuantity.setText("Edit Quantity");
        EditQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditQuantityActionPerformed(evt);
            }
        });

        ItemsTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Requested Items", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(ItemsTable2);

        RequestsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Requests Available"));
        RequestsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        RequestsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                RequestsListValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(RequestsList);

        DeleteRequestedItem.setText("Delete Item");
        DeleteRequestedItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRequestedItemActionPerformed(evt);
            }
        });

        DeleteRequest.setText("Delete Request");
        DeleteRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManageReqestsTabLayout = new javax.swing.GroupLayout(ManageReqestsTab);
        ManageReqestsTab.setLayout(ManageReqestsTabLayout);
        ManageReqestsTabLayout.setHorizontalGroup(
            ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DeleteRequest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteRequestedItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addComponent(EditQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ManageReqestsTabLayout.setVerticalGroup(
            ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(DeleteRequestedItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DeleteRequest)
                            .addComponent(EditQuantity)))
                    .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        DeptPane.addTab("Manage Requests", ManageReqestsTab);

        ItemsTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Delivered Items", "Delivered Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(ItemsTable3);

        DeliveriesList.setBorder(javax.swing.BorderFactory.createTitledBorder("Deliveries Available"));
        DeliveriesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        DeliveriesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                DeliveriesListValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(DeliveriesList);

        confirmAll.setText("Confirm All");
        confirmAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAllActionPerformed(evt);
            }
        });

        confirmSelected.setText("Confirm Selected");
        confirmSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeliveriesTabLayout = new javax.swing.GroupLayout(DeliveriesTab);
        DeliveriesTab.setLayout(DeliveriesTabLayout);
        DeliveriesTabLayout.setHorizontalGroup(
            DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveriesTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(DeliveriesTabLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmAll, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DeliveriesTabLayout.setVerticalGroup(
            DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveriesTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addGroup(DeliveriesTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(confirmSelected)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmAll)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        DeptPane.addTab("Deliveries", DeliveriesTab);

        pendingItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Total Pending Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(pendingItemsTable);

        javax.swing.GroupLayout PendingItemsTabLayout = new javax.swing.GroupLayout(PendingItemsTab);
        PendingItemsTab.setLayout(PendingItemsTabLayout);
        PendingItemsTabLayout.setHorizontalGroup(
            PendingItemsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
            .addGroup(PendingItemsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PendingItemsTabLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PendingItemsTabLayout.setVerticalGroup(
            PendingItemsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
            .addGroup(PendingItemsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PendingItemsTabLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        DeptPane.addTab("Pending Items", PendingItemsTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeptPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeptPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemActionPerformed
        
        if (this.ItemsTable.getSelectedRow() == -1) {
            if (ItemsTable.getRowCount() == 0) {
                Message.setText("Table Is Empty");
            } else {
                Message.setText("No Items Selected");
            }
        } else {
            try {
                model.removeRow(ItemsTable.getSelectedRow());
            } catch (Exception e) {
                System.out.printf("");
            }
        }
    }//GEN-LAST:event_DeleteItemActionPerformed

    private void AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemActionPerformed
        
        if (ItemsList.getSelectedIndex() == -1) {
            Message.setText("No Item Selected");
            return;
        }
        Items selectedItem = (Items) ItemsList.getSelectedValue();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (selectedItem.equals((Items) model.getValueAt(i, 0))) {
                Message.setText("Already added");
                return;
            }
        }
        try {
            model.addRow(new Object[]{selectedItem, "1"});
        } catch (Exception e) {
            System.out.print("");
        }
    }//GEN-LAST:event_AddItemActionPerformed

    private void OrderItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderItemsActionPerformed
        
        if (model.getRowCount() == 0) {
            Message.setText("No Items to order");
            return;
        }
        em = emf.createEntityManager();
        RequestOfItems req = new RequestOfItems();
        req.setDeptId(new Departments(this.CurDeptartmentID));
        req.setRequestDate(new Date());
        req.setAccepted('N');
        em.getTransaction().begin();
        em.persist(req);
        DetailedRequestOfItems dreq;
        Items selectedItem;
        for (int i = 0; i < model.getRowCount(); i++) {
            dreq = new DetailedRequestOfItems();
            selectedItem = (Items) model.getValueAt(i, 0);
            dreq.setDetailedRequestOfItemsPK(new DetailedRequestOfItemsPK(req.getRequestId(), selectedItem.getItemId()));
            Integer sth = Integer.parseInt(model.getValueAt(i, 1).toString());
            dreq.setRequestedQuantity(sth);
            em.persist(dreq);
            dreq = null;
        }
        em.getTransaction().commit();
        em = null;
        model.setRowCount(0);
        Message.setText("Order Successful");
        updateState();
    }//GEN-LAST:event_OrderItemsActionPerformed

    private void EditQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditQuantityActionPerformed
        if (ItemsTable2.getSelectedRow() == -1) {
            if (ItemsTable2.getRowCount() == 0) {
                Message.setText("Table Is Empty");
                return;
            } else {
                Message.setText("No Items Selected");
                return;
            }
        }//if
        em = emf.createEntityManager();
        int selectedrow = ItemsTable2.getSelectedRow();
        Items selecteditem = (Items) ItemsTable2.getValueAt(selectedrow, 0);
        RequestOfItems roi = (RequestOfItems) RequestsList.getSelectedValue();
        DetailedRequestOfItems droi = (DetailedRequestOfItems) em.createNamedQuery("DetailedRequestOfItems.findByRequestIdAndItemID")
                .setParameter("requestId", roi.getRequestId())
                .setParameter("itemId", selecteditem.getItemId())
                .getSingleResult();
        int newQuantity = Integer.parseInt(JOptionPane.showInputDialog("Enter The New Quantity"));
        em.getTransaction().begin();
        droi.setRequestedQuantity(newQuantity);
        em.getTransaction().commit();
        model2.setValueAt(newQuantity, selectedrow, 1);
        em = null;
        Message.setText("Edit Successful");
        updateState();
    }//GEN-LAST:event_EditQuantityActionPerformed

    private void DeleteRequestedItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRequestedItemActionPerformed
        if (this.ItemsTable2.getSelectedRow() == -1) {
            if (ItemsTable2.getRowCount() == 0) {
                Message.setText("Table Is Empty");
            } else {
                Message.setText("No Items Selected");
            }
        } else {
            em = emf.createEntityManager();
            int selectedrow = ItemsTable2.getSelectedRow();
            Items selecteditem = (Items) ItemsTable2.getValueAt(selectedrow, 0);
            RequestOfItems roi = (RequestOfItems) RequestsList.getSelectedValue();
            DetailedRequestOfItems droi = (DetailedRequestOfItems) em.createNamedQuery("DetailedRequestOfItems.findByRequestIdAndItemID")
                    .setParameter("requestId", roi.getRequestId())
                    .setParameter("itemId", selecteditem.getItemId())
                    .getSingleResult();
            em.getTransaction().begin();
            em.remove(droi);
            em.getTransaction().commit();
            model2.removeRow(selectedrow);
            if (ItemsTable2.getRowCount() == 0) {
                DeleteRequestActionPerformed(evt);
            }
            Message.setText("Delete Successful");
            em = null;
        }//else
    }//GEN-LAST:event_DeleteRequestedItemActionPerformed

    private void DeleteRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRequestActionPerformed
        em = emf.createEntityManager();
        if (RequestsList.getSelectedIndex() == -1) {
            Message.setText("No Request To Delete");
            return;
        }
        RequestOfItems roi = (RequestOfItems) RequestsList.getSelectedValue();
        RequestOfItems roitd = (RequestOfItems) em.createNamedQuery("RequestOfItems.findByRequestId")
                .setParameter("requestId", roi.getRequestId())
                .getSingleResult();
        em.getTransaction().begin();
        em.remove(roitd);
        em.getTransaction().commit();
        updateState();
        em = null;
        Message.setText("Delete Successful");
    }//GEN-LAST:event_DeleteRequestActionPerformed

    private void RequestsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_RequestsListValueChanged
        em = emf.createEntityManager();
        RequestOfItems roi = (RequestOfItems) RequestsList.getSelectedValue();
        if (roi == null) {
            return;
        }
        if (roi.getAccepted() == 'Y') {
            this.EditQuantity.setEnabled(false);
            this.DeleteRequestedItem.setEnabled(false);
            this.DeleteRequest.setEnabled(false);
        } else {
            this.EditQuantity.setEnabled(true);
            this.DeleteRequestedItem.setEnabled(true);
            this.DeleteRequest.setEnabled(true);
        }
        
        model2.setRowCount(0);
        List<DetailedRequestOfItems> view = em.createNamedQuery("DetailedRequestOfItems.findByRequestId")
                .setParameter("requestId", roi.getRequestId())
                .getResultList();
        for (DetailedRequestOfItems d : view) {
            try {
                model2.addRow(new Object[]{d.getItems(), d.getRequestedQuantity()});
            } catch (Exception e) {
                System.out.println("");
            }
        }
        em = null;
    }//GEN-LAST:event_RequestsListValueChanged

    private void DeliveriesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_DeliveriesListValueChanged
        if (DeliveriesList.getSelectedIndex() == -1) {
            return;
        }
        em = emf.createEntityManager();
        DeliveryForm df = (DeliveryForm) DeliveriesList.getSelectedValue();
        if(df.getConfirmed()=='Y'){
            confirmSelected.setEnabled(false);
        }
        else{
            confirmSelected.setEnabled(true);
        }
        model3.setRowCount(0);
        List<DetailedDelivery> view = em.createNamedQuery("DetailedDelivery.findByDeliveryId")
                .setParameter("deliveryId", df.getDeliveryId())
                .getResultList();
        for (DetailedDelivery d : view) {
            try {
                model3.addRow(new Object[]{d.getItems(), d.getDeliveredQuantity()});
            } catch (Exception e) {
                System.out.println("");
            }
        }
        em = null;
    }//GEN-LAST:event_DeliveriesListValueChanged

    private void confirmAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAllActionPerformed
        em=emf.createEntityManager();
        dfv = (Vector<DeliveryForm>) em.createNamedQuery("DeliveryForm.findConfirmedByDeptId")
                .setParameter("confirmed", 'N')
                .setParameter("deptId", CurDeptartmentID)
                .getResultList();
        if (dfv.size()==0){
            Message.setText("All deliveries were already confirmed");
        }
        em.getTransaction().begin();
        for (DeliveryForm df : dfv) {
            df.setConfirmed('Y');
        }
        em.getTransaction().commit();
        updateState();
        Message.setText("All deliveries confirmed");
    }//GEN-LAST:event_confirmAllActionPerformed

    private void confirmSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmSelectedActionPerformed
        if (DeliveriesList.getSelectedIndex() == -1) {
            return;
        }
        em = emf.createEntityManager();
        DeliveryForm df = (DeliveryForm) DeliveriesList.getSelectedValue();
        DeliveryForm dfed = (DeliveryForm) em.createNamedQuery("DeliveryForm.findByDeliveryId")
                .setParameter("deliveryId", df.getDeliveryId())
                .getSingleResult();
        em.getTransaction().begin();
        dfed.setConfirmed('Y');
        em.getTransaction().commit();
        updateState();
        em = null;
    }//GEN-LAST:event_confirmSelectedActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItem;
    private javax.swing.JButton DeleteItem;
    private javax.swing.JButton DeleteRequest;
    private javax.swing.JButton DeleteRequestedItem;
    private javax.swing.JList DeliveriesList;
    private javax.swing.JPanel DeliveriesTab;
    private javax.swing.JTabbedPane DeptPane;
    private javax.swing.JButton EditQuantity;
    private javax.swing.JList ItemsList;
    private javax.swing.JTable ItemsTable;
    private javax.swing.JTable ItemsTable2;
    private javax.swing.JTable ItemsTable3;
    private javax.swing.JPanel ManageReqestsTab;
    private javax.swing.JButton OrderItems;
    private javax.swing.JPanel OrderTab;
    private javax.swing.JPanel PendingItemsTab;
    private javax.swing.JList RequestsList;
    private javax.swing.JButton confirmAll;
    private javax.swing.JButton confirmSelected;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable pendingItemsTable;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel Message;
    private WebPopOver pop;

    void updateState() {
        emf.getCache().evictAll();
        em = emf.createEntityManager();
        Query qr = em.createNamedQuery("Items.findAll");
        allItems = qr.getResultList();
        v = new Vector();
        for (Items i : allItems) {
            v.add(i);
        }
        ItemsList.setListData(v);
        
        v2 = new Vector();
        allrequests = em.createNamedQuery("RequestOfItems.findAll").getResultList();
        for (RequestOfItems r : allrequests) {
            if (r.getDeptId().getDeptId() == CurDeptartmentID) {
                v2.add(r);
            }
        }
        RequestsList.setListData(v2);
        
        v3 = new Vector();
        alldeliveries = em.createNamedQuery("DeliveryForm.findAll").getResultList();
        for (DeliveryForm df : alldeliveries) {
            v3.add(df);
        }
        this.DeliveriesList.setListData(v3);
        
        Vector<NeededItemsPerDept> nipdv = (Vector< NeededItemsPerDept>) em.createNamedQuery("NeededItemsPerDept.findByDeptId")
                .setParameter("deptId", CurDeptartmentID)
                .getResultList();
        model4.setRowCount(0);
        for (NeededItemsPerDept nipd : nipdv) {
            model4.addRow(new Object[]{nipd.getItemId(), nipd.getNeededQuantity()});
        }
        
        em = null;
    }
}
