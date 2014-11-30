package StorePackage;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MahmoodKhalid
 */
public class DeptUI extends javax.swing.JFrame implements WindowListener {

    int CurDeptartmentID = 5;// this variable is to be determined from the main UI
    EntityManagerFactory emf = null;
    EntityManager em = null;
    DefaultTableModel model;
    DefaultTableModel model2;
    DefaultTableModel model3;
    
    static Connection con;
    static Statement stmt;
    static String username = "AZM";
    static String password = "azm";
    static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    ResultSet rs;
    Vector v;
    Vector v2;
    Vector v3;
    Vector v4;
    List<Items> allItems;
    List<RequestOfItems> allrequests;
    List<DeliveryForm> alldeliveries;
    List<RequestOfItems> deptrequests;
    int viewedRequest = -1;
    boolean isDelivered = false;
    public DeptUI() {
        initComponents();
        setTitle("Department UI");
        emf = Persistence.createEntityManagerFactory("AZMprojectPU");
        em = emf.createEntityManager();
        Query qr = em.createNamedQuery("Items.findAll");
        allItems = qr.getResultList();
        v = new Vector();
        for (Items i : allItems) {
            v.add(i.getItemName());
        }
        ItemsList.setListData(v);
        model = new DefaultTableModel();
        model = (DefaultTableModel) ItemsTable.getModel();
        model2 = new DefaultTableModel();
        model2 = (DefaultTableModel) ItemsTable2.getModel();
        model3 = new DefaultTableModel();
        model3 = (DefaultTableModel) ItemsTable3.getModel();
        
        v2 = new Vector();
        v4 = new Vector();
        allrequests = em.createNamedQuery("RequestOfItems.findAll").getResultList();
        for (RequestOfItems r : allrequests) {
            if(r.getDeptId().getDeptId()==CurDeptartmentID){
            v2.add(r.getRequestId());
            v4.add(r);
            }
        }
        RequestsList.setListData(v2);
        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DeptUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        v3 = new Vector();
        alldeliveries = em.createNamedQuery("DeliveryForm.findAll").getResultList();
        RequestOfItems roi = new RequestOfItems();
        for (DeliveryForm df : alldeliveries) {
            for(int i =0;i<v4.size();i++){
                roi = (RequestOfItems) v4.get(i);
                if(roi.getRequestId()==df.getRequestId().getRequestId())
                v3.add(df.getDeliveryId());
            }
        }
        this.DeliveriesList.setListData(v3);
        
        EditQuantity.setEnabled(false);
        DeleteRequestedItem.setEnabled(false);
        DeleteRequest.setEnabled(false);
        em = null;
        addWindowListener(this);
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
        Message = new javax.swing.JLabel();
        ManageReqestsTab = new javax.swing.JPanel();
        EditQuantity = new javax.swing.JButton();
        ViewRequest = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ItemsTable2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        RequestsList = new javax.swing.JList();
        Message2 = new javax.swing.JLabel();
        DeleteRequestedItem = new javax.swing.JButton();
        DeleteRequest = new javax.swing.JButton();
        DeliveriesTab = new javax.swing.JPanel();
        ViewDelivery = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        ItemsTable3 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        DeliveriesList = new javax.swing.JList();
        Message3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(OrderTabLayout.createSequentialGroup()
                        .addGroup(OrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OrderTabLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(OrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(OrderTabLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(Message, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(OrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(AddItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DeleteItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(OrderTabLayout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(OrderItems)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        OrderTabLayout.setVerticalGroup(
            OrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderTabLayout.createSequentialGroup()
                .addGroup(OrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OrderTabLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(AddItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DeleteItem)
                        .addGap(18, 18, 18)
                        .addComponent(Message, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OrderTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OrderItems)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DeptPane.addTab("Order", OrderTab);

        EditQuantity.setText("Edit Quantity");
        EditQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditQuantityActionPerformed(evt);
            }
        });

        ViewRequest.setText("View Request");
        ViewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewRequestActionPerformed(evt);
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
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Message2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(DeleteRequest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DeleteRequestedItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EditQuantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ViewRequest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 295, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ManageReqestsTabLayout.setVerticalGroup(
            ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                        .addComponent(ViewRequest)
                        .addGap(4, 4, 4)
                        .addComponent(EditQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteRequestedItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteRequest)
                        .addGap(11, 11, 11)
                        .addComponent(Message2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        DeptPane.addTab("Manage Requests", ManageReqestsTab);

        ViewDelivery.setText("View Delivery");
        ViewDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewDeliveryActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout DeliveriesTabLayout = new javax.swing.GroupLayout(DeliveriesTab);
        DeliveriesTab.setLayout(DeliveriesTabLayout);
        DeliveriesTabLayout.setHorizontalGroup(
            DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveriesTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(DeliveriesTabLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ViewDelivery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 344, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DeliveriesTabLayout.createSequentialGroup()
                    .addGap(256, 256, 256)
                    .addComponent(Message3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(305, Short.MAX_VALUE)))
        );
        DeliveriesTabLayout.setVerticalGroup(
            DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveriesTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeliveriesTabLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeliveriesTabLayout.createSequentialGroup()
                        .addComponent(ViewDelivery)
                        .addGap(46, 46, 46)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DeliveriesTabLayout.createSequentialGroup()
                    .addGap(143, 143, 143)
                    .addComponent(Message3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(340, Short.MAX_VALUE)))
        );

        DeptPane.addTab("Deliveries", DeliveriesTab);

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
        // TODO add your handling code here:
        Message.setText("");
        Message2.setText("");
        Message3.setText("");
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
        Message.setText("");
        Message2.setText("");
        Message3.setText("");
        if (ItemsList.getSelectedIndex() == -1) {
            Message.setText("No Item Selected");
            return;
        }
        String selectedItem = (String) ItemsList.getSelectedValue();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (selectedItem.equals((String) model.getValueAt(i, 0))) {
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
        Message.setText("");
        Message2.setText("");
        Message3.setText("");
        if (model.getRowCount() == 0) {
            Message.setText("No Items to order");
            return;
        }
        em = emf.createEntityManager();
        RequestOfItems req = new RequestOfItems();
        req.setDeptId(new Departments(this.CurDeptartmentID));
        req.setRequestDate(new Date());
        int curRequestID = 0;
        try {
            rs = stmt.executeQuery("select max(Request_ID) from Request_Of_Items");
            rs.next();
            curRequestID = rs.getInt(1) + 1;
        } catch (SQLException ex) {
            Logger.getLogger(DeptUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        req.setRequestId(new Integer(curRequestID));
        em.getTransaction().begin();
        em.persist(req);
        em.getTransaction().commit();
        em = null;
        RequestsList.removeAll();
        v2.add(curRequestID);
        RequestsList.setListData(v2);

        DetailedRequestOfItems dreq;
        String ItemName;
        int curItemID = 0;
        List<Items> selectedItem;
        for (int i = 0; i < model.getRowCount(); i++) {

            em = emf.createEntityManager();
            dreq = new DetailedRequestOfItems();
            ItemName = (String) model.getValueAt(i, 0);
            selectedItem = em.createNamedQuery("Items.findAll").getResultList();
            for (Items si : selectedItem) {
                if (si.getItemName().equals(ItemName)) {
                    curItemID = si.getItemId();
                }
            }
            dreq.setDetailedRequestOfItemsPK(new DetailedRequestOfItemsPK(curRequestID, curItemID));
            Integer sth = Integer.parseInt(model.getValueAt(i, 1).toString());
            dreq.setRequestedQuantity(sth);

            em.getTransaction().begin();
            em.persist(dreq);
            em.getTransaction().commit();
            em = null;
            dreq = null;
        }
        model.setRowCount(0);
        Message.setText("Order Successful");
    }//GEN-LAST:event_OrderItemsActionPerformed

    private void ViewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewRequestActionPerformed
        Message.setText("");
        Message2.setText("");
        Message3.setText("");
        if (RequestsList.getSelectedIndex() == -1) {
            Message2.setText("No Request Selected");
            return;
        }
        em = emf.createEntityManager();
        Integer selectedItem = (Integer) RequestsList.getSelectedValue();
        viewedRequest = selectedItem;
        model2.setRowCount(0);
        List<DetailedRequestOfItems> view = em.createNamedQuery("DetailedRequestOfItems.findAll").getResultList();
        for (DetailedRequestOfItems d : view) {
            if (d.getDetailedRequestOfItemsPK().getRequestId() == selectedItem) {
                for (Items vi : allItems) {
                    if (d.getDetailedRequestOfItemsPK().getItemId() == vi.getItemId()) {
                        try {
                            model2.addRow(new Object[]{vi.getItemName(), d.getRequestedQuantity()});
                        } catch (Exception e) {
                            System.out.println("");
                        }//catch
                    }//if
                }//for
            }//if
        }//for
        em = null;
    }//GEN-LAST:event_ViewRequestActionPerformed

    private void EditQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditQuantityActionPerformed
        Message.setText("");
        Message2.setText("");
        Message3.setText("");
        if (ItemsTable2.getSelectedRow() == -1) {
            if (ItemsTable2.getRowCount() == 0) {Message2.setText("Table Is Empty"); return;}
            else {Message2.setText("No Items Selected"); return;}
        }//if
        em = emf.createEntityManager();
        int selectedrow = ItemsTable2.getSelectedRow();
        String selecteditem = (String)ItemsTable2.getValueAt(selectedrow, 0);
        int selectedID=0;
        for(Items sidel:allItems)
            if(sidel.getItemName().equals(selecteditem))selectedID = sidel.getItemId();
        int newQuantity = Integer.parseInt(JOptionPane.showInputDialog("Enter The New Quantity"));
        try {
             stmt.executeUpdate("UPDATE DETAILED_REQUEST_OF_ITEMS SET REQUESTED_QUANTITY="+newQuantity+"WHERE ITEM_ID="+selectedID+"AND REQUEST_ID = "+viewedRequest);
             model2.setValueAt(newQuantity, selectedrow, 1);
             } catch (SQLException e) {
                   System.out.printf("");
                }
        em = null;
        Message2.setText("Edit Successful");       
    }//GEN-LAST:event_EditQuantityActionPerformed

    private void DeleteRequestedItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRequestedItemActionPerformed
        Message.setText("");
        Message2.setText("");
        Message3.setText("");
        if (this.ItemsTable2.getSelectedRow() == -1) {
            if (ItemsTable2.getRowCount() == 0) {
                Message2.setText("Table Is Empty");
            } else {
                Message2.setText("No Items Selected");
            }
        } else {
            em = emf.createEntityManager();
            int selectedrow = ItemsTable2.getSelectedRow();
            String selecteditem = (String)ItemsTable2.getValueAt(selectedrow, 0);
            int selectedID=0;
            for(Items sidel:allItems){
                if(sidel.getItemName().equals(selecteditem))selectedID = sidel.getItemId();
            }//for
            try {
                 stmt.executeUpdate("DELETE FROM DETAILED_REQUEST_OF_ITEMS WHERE ITEM_ID ="+selectedID+"and REQUEST_ID ="+viewedRequest);
                 model2.removeRow(selectedrow);
                 } catch (Exception e) {
                       System.out.printf("");
                    }
            if (ItemsTable2.getRowCount() == 0)DeleteRequestActionPerformed(evt);
            Message2.setText("Delete Successful");
            em = null;
        }//else
    }//GEN-LAST:event_DeleteRequestedItemActionPerformed

    private void DeleteRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRequestActionPerformed
        Message.setText("");
        Message2.setText("");
        Message3.setText("");
        em = emf.createEntityManager();
        if(viewedRequest==-1){Message2.setText("No Request To Delete");return;}
        try {
            stmt.executeUpdate("DELETE FROM REQUEST_OF_ITEMS WHERE REQUEST_ID ="+viewedRequest);
        } catch (SQLException ex) {
            Logger.getLogger(DeptUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        viewedRequest = -1;
        RequestsList.removeAll();
        allrequests = null;
        allrequests = em.createNamedQuery("RequestOfItems.findAll").getResultList();
        v2.setSize(0);
        for (RequestOfItems r : allrequests) {
            v2.add(r.getRequestId());
        }
        RequestsList.setListData(v2);
        em = null;
        Message2.setText("Delete Successful");
    }//GEN-LAST:event_DeleteRequestActionPerformed

    private void RequestsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_RequestsListValueChanged
        Message.setText("");
        Message2.setText("");
        Message3.setText("");
        em = emf.createEntityManager();
        Integer selectedItem = (Integer) RequestsList.getSelectedValue();
        List<DeliveryForm> allDelivered = em.createNamedQuery("DeliveryForm.findAll").getResultList();
        for(DeliveryForm df:allDelivered)
           if(df.getRequestId().getRequestId()==selectedItem)
           {isDelivered = true;
           Message2.setText("Request is Delivered");
           em = null;
           this.EditQuantity.setEnabled(false);
           this.DeleteRequestedItem.setEnabled(false);
           this.DeleteRequest.setEnabled(false);
           return;}
        Message2.setText("Request is not Delivered");
        this.EditQuantity.setEnabled(true);
        this.DeleteRequestedItem.setEnabled(true);
        this.DeleteRequest.setEnabled(true);
        em = null;
    }//GEN-LAST:event_RequestsListValueChanged

    private void ViewDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewDeliveryActionPerformed
        Message.setText("");
        Message2.setText("");
        Message3.setText("");
        if (this.DeliveriesList.getSelectedIndex() == -1) {
            Message3.setText("No Delivery Selected");
            return;
        }
        em = emf.createEntityManager();
        model3.setRowCount(0);
        Integer selectedItem = (Integer) DeliveriesList.getSelectedValue();
        List<DetailedDelivery> view = em.createNamedQuery("DetailedDelivery.findAll").getResultList();
        for (DetailedDelivery dd : view) {
            if (dd.getDetailedDeliveryPK().getDeliveryId() == selectedItem) {
                for (Items vi : allItems) {
                    if (dd.getDetailedDeliveryPK().getItemId() == vi.getItemId()) {
                        try {
                            model3.addRow(new Object[]{vi.getItemName(), dd.getDeliveredQuantity()});
                        } catch (Exception e) {
                            System.out.println("");
                        }//catch
                    }//if
                }//for
            }//if
        }//for
        em = null;
    }//GEN-LAST:event_ViewDeliveryActionPerformed

    private void DeliveriesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_DeliveriesListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_DeliveriesListValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeptUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeptUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeptUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeptUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeptUI().setVisible(true);
                new PurchasingManager().setVisible(true);
            }
        });
    }

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
    private javax.swing.JLabel Message;
    private javax.swing.JLabel Message2;
    private javax.swing.JLabel Message3;
    private javax.swing.JButton OrderItems;
    private javax.swing.JPanel OrderTab;
    private javax.swing.JList RequestsList;
    private javax.swing.JButton ViewDelivery;
    private javax.swing.JButton ViewRequest;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent we) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        em = emf.createEntityManager();
        em.close();
        emf.close();
        System.gc();
    }

    @Override
    public void windowClosed(WindowEvent we) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
