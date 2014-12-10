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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ali Jayousi
 */
public class StoreManager extends javax.swing.JFrame {
    
   
    EntityManagerFactory emf = null;
    EntityManager em = null;
    DefaultTableModel model1;
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
    Vector<RequestOfItems> dfv;


    public StoreManager() {
       

        initComponents();
        Message = new JLabel();
        pop = new WebPopOver(this);
        pop.setCloseOnFocusLoss(true);
        pop.add(Message);
        pop.setMargin(15);
        Message.addPropertyChangeListener("text", new PropertyChangeListener() {
            
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                pop.show(StoreManager.this);
            }
        });
        
        emf = Persistence.createEntityManagerFactory("AZMprojectPU");
        em = emf.createEntityManager();
        
        dfv = (Vector<RequestOfItems>) em.createNamedQuery("RequestOfItems.findByAccepted")
                .setParameter("accepted", 'N')
                .getResultList();

        // create Notification
        WebNotificationPopup notif = NotificationManager.showNotification(this, "" + (dfv.size() > 0 ? dfv.size() : "No") + " new requests.");
        notif.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (dfv.size() > 0) {
                    StorPane.setSelectedIndex(2);
                }
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
        
        StorPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateState();
            }
        });
        updateState();
        initState();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StorPane = new javax.swing.JTabbedPane();
        ViewItems = new javax.swing.JPanel();
        scrol2 = new javax.swing.JScrollPane();
        AllItemsTable = new javax.swing.JTable();
        ManageReqestsTab = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ItemsTable2 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        pendingItemsDept = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        departments3 = new javax.swing.JComboBox();
        AddItem = new javax.swing.JButton();
        DeleteItem = new javax.swing.JButton();
        deliverRequest = new javax.swing.JButton();
        PendingItemsTab = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        pendingItemsTable = new javax.swing.JTable();
        ManageReqestsTab1 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        ItemsTableRequests = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        RequestsList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        departments2 = new javax.swing.JComboBox();
        confirmSelected = new javax.swing.JButton();
        confirmAll = new javax.swing.JButton();
        DeliveriesTab = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        ItemsTableDeliveries = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        DeliveriesList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        departments1 = new javax.swing.JComboBox();
        DeleteDeliveredItem = new javax.swing.JButton();
        DeleteDelivery = new javax.swing.JButton();
        EditQuantity = new javax.swing.JButton();
        receivingForms = new javax.swing.JPanel();
        scrol5 = new javax.swing.JScrollPane();
        receivingFormItemsTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        suppliersReceiving = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        ReceivingFormsList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/StorePackage/zakat.jpg")).getImage());
        setResizable(false);

        scrol2.setPreferredSize(new java.awt.Dimension(400, 350));

        AllItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Available Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrol2.setViewportView(AllItemsTable);

        javax.swing.GroupLayout ViewItemsLayout = new javax.swing.GroupLayout(ViewItems);
        ViewItems.setLayout(ViewItemsLayout);
        ViewItemsLayout.setHorizontalGroup(
            ViewItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrol2, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
        );
        ViewItemsLayout.setVerticalGroup(
            ViewItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrol2, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addContainerGap())
        );

        StorPane.addTab("Items in Storage", ViewItems);

        ItemsTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity"
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

        pendingItemsDept.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Available Quantity", "Needed Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(pendingItemsDept);

        jLabel5.setText("Choose Department:");

        departments3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        departments3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departments3ActionPerformed(evt);
            }
        });

        AddItem.setText("Add Item");
        AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemActionPerformed(evt);
            }
        });

        DeleteItem.setText("Delete Item");
        DeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteItemActionPerformed(evt);
            }
        });

        deliverRequest.setText("Deliver Request");
        deliverRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliverRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManageReqestsTabLayout = new javax.swing.GroupLayout(ManageReqestsTab);
        ManageReqestsTab.setLayout(ManageReqestsTabLayout);
        ManageReqestsTabLayout.setHorizontalGroup(
            ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(departments3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                        .addComponent(AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deliverRequest)))
                .addContainerGap())
        );
        ManageReqestsTabLayout.setVerticalGroup(
            ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departments3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteItem)
                    .addComponent(AddItem)
                    .addComponent(deliverRequest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        StorPane.addTab("Deliver a Request", ManageReqestsTab);

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
            .addGap(0, 574, Short.MAX_VALUE)
            .addGroup(PendingItemsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PendingItemsTabLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        StorPane.addTab("Pending Items", PendingItemsTab);

        ItemsTableRequests.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(ItemsTableRequests);

        RequestsList1.setBorder(javax.swing.BorderFactory.createTitledBorder("Requests Available"));
        RequestsList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        RequestsList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                RequestsList1ValueChanged(evt);
            }
        });
        jScrollPane12.setViewportView(RequestsList1);

        jLabel2.setText("Choose Department:");

        departments2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        departments2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departments2ActionPerformed(evt);
            }
        });

        confirmSelected.setText("Confirm Selected");
        confirmSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmSelectedActionPerformed(evt);
            }
        });

        confirmAll.setText("Confirm All");
        confirmAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManageReqestsTab1Layout = new javax.swing.GroupLayout(ManageReqestsTab1);
        ManageReqestsTab1.setLayout(ManageReqestsTab1Layout);
        ManageReqestsTab1Layout.setHorizontalGroup(
            ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                        .addGroup(ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(departments2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(confirmSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confirmAll, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ManageReqestsTab1Layout.setVerticalGroup(
            ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departments2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                        .addComponent(confirmSelected)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmAll))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        StorPane.addTab("Requests", ManageReqestsTab1);

        ItemsTableDeliveries.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(ItemsTableDeliveries);

        DeliveriesList.setBorder(javax.swing.BorderFactory.createTitledBorder("Deliveries Available"));
        DeliveriesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        DeliveriesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                DeliveriesListValueChanged(evt);
            }
        });
        jScrollPane13.setViewportView(DeliveriesList);

        jLabel3.setText("Choose Department:");

        departments1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        departments1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departments1ActionPerformed(evt);
            }
        });

        DeleteDeliveredItem.setText("Delete Item");
        DeleteDeliveredItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteDeliveredItemActionPerformed(evt);
            }
        });

        DeleteDelivery.setText("Delete Delivery");
        DeleteDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteDeliveryActionPerformed(evt);
            }
        });

        EditQuantity.setText("Edit Quantity");
        EditQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditQuantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeliveriesTabLayout = new javax.swing.GroupLayout(DeliveriesTab);
        DeliveriesTab.setLayout(DeliveriesTabLayout);
        DeliveriesTabLayout.setHorizontalGroup(
            DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveriesTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(DeliveriesTabLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departments1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(DeliveriesTabLayout.createSequentialGroup()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DeleteDelivery, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(DeleteDeliveredItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        DeliveriesTabLayout.setVerticalGroup(
            DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveriesTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departments1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DeliveriesTabLayout.createSequentialGroup()
                        .addComponent(DeleteDeliveredItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DeleteDelivery)
                            .addComponent(EditQuantity)))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        StorPane.addTab("Deliveries", DeliveriesTab);

        receivingFormItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Items", "Quantity", "Unit Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrol5.setViewportView(receivingFormItemsTable);

        jLabel4.setText("Choose Supplier:");

        suppliersReceiving.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        suppliersReceiving.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersReceivingActionPerformed(evt);
            }
        });

        ReceivingFormsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Receiving Forms Available"));
        ReceivingFormsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ReceivingFormsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ReceivingFormsListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ReceivingFormsList);

        javax.swing.GroupLayout receivingFormsLayout = new javax.swing.GroupLayout(receivingForms);
        receivingForms.setLayout(receivingFormsLayout);
        receivingFormsLayout.setHorizontalGroup(
            receivingFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receivingFormsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receivingFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrol5, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(receivingFormsLayout.createSequentialGroup()
                        .addGroup(receivingFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(receivingFormsLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(suppliersReceiving, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        receivingFormsLayout.setVerticalGroup(
            receivingFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receivingFormsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receivingFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suppliersReceiving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrol5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        StorPane.addTab("Receiving forms", receivingForms);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StorPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StorPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RequestsList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_RequestsList1ValueChanged
        em = emf.createEntityManager();
        RequestOfItems roi = (RequestOfItems) RequestsList1.getSelectedValue();
        if (roi == null) {
            return;
        }
        model2=(DefaultTableModel)ItemsTableRequests.getModel();
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
    }//GEN-LAST:event_RequestsList1ValueChanged

    private void departments2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departments2ActionPerformed
        em=emf.createEntityManager();
        Vector<RequestOfItems> allRequests;
        if (departments2.getSelectedIndex() == 0 || departments2.getSelectedItem() == null) {
            allRequests = (Vector<RequestOfItems>) em.createNamedQuery("RequestOfItems.findAll")
            .getResultList();
        } else {
            Departments dep = (Departments) em.createNamedQuery("Departments.findByDeptName")
            .setParameter("deptName", departments2.getSelectedItem())
            .getSingleResult();
            allRequests = (Vector<RequestOfItems>) em.createNamedQuery("RequestOfItems.findByDeptId")
            .setParameter("deptId", dep.getDeptId())
            .getResultList();
        }
        DeliveriesList.setListData(allRequests);
    }//GEN-LAST:event_departments2ActionPerformed

    private void DeliveriesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_DeliveriesListValueChanged
        if (DeliveriesList.getSelectedIndex() == -1) {
            return;
        }
        em = emf.createEntityManager();
        DeliveryForm df = (DeliveryForm) DeliveriesList.getSelectedValue();
        model1=(DefaultTableModel) ItemsTableDeliveries.getModel();
        model1.setRowCount(0);
        List<DetailedDelivery> view = em.createNamedQuery("DetailedDelivery.findByDeliveryId")
        .setParameter("deliveryId", df.getDeliveryId())
        .getResultList();
        for (DetailedDelivery d : view) {
            model1.addRow(new Object[]{d.getItems(), d.getDeliveredQuantity()});
        }
        em = null;
    }//GEN-LAST:event_DeliveriesListValueChanged

    private void departments1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departments1ActionPerformed
        em=emf.createEntityManager();
        Vector<DeliveryForm> allDeliveries;
        if (departments1.getSelectedIndex() == 0||departments1.getSelectedItem() == null) {
            allDeliveries = (Vector<DeliveryForm>) em.createNamedQuery("DeliveryForm.findAll")
            .getResultList();
        } else {
            Departments dep = (Departments) em.createNamedQuery("Departments.findByDeptName")
            .setParameter("deptName", departments1.getSelectedItem())
            .getSingleResult();
            allDeliveries = (Vector<DeliveryForm>) em.createNamedQuery("DeliveryForm.findByDeptId")
            .setParameter("deptId", dep.getDeptId())
            .getResultList();
        }
        DeliveriesList.setListData(allDeliveries);
    }//GEN-LAST:event_departments1ActionPerformed

    private void suppliersReceivingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersReceivingActionPerformed
        em=emf.createEntityManager();
        Vector<ReceivingForm> allReceivingForms;
        Suppliers sup = null;
        if (suppliersReceiving.getSelectedIndex() == 0||suppliersReceiving.getSelectedItem() == null) {
            allReceivingForms = (Vector<ReceivingForm>) em.createNamedQuery("ReceivingForm.findAll")
            .getResultList();
        }
        else{
            try{
                sup = (Suppliers) em.createNamedQuery("Suppliers.findBySupplierName")
                .setParameter("supplierName", suppliersReceiving.getSelectedItem())
                .getSingleResult();
            }
            catch(NullPointerException e){
                System.out.println(sup);
            }
            allReceivingForms=(Vector < ReceivingForm >)em.createNamedQuery("ReceivingForm.findBySupplier")
            .setParameter("supplierId", sup.getSupplierId())
            .getResultList();
        }
        ReceivingFormsList.setListData(allReceivingForms);
    }//GEN-LAST:event_suppliersReceivingActionPerformed

    private void ReceivingFormsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ReceivingFormsListValueChanged
        em = emf.createEntityManager();
        ReceivingForm rf = (ReceivingForm)ReceivingFormsList.getSelectedValue();
        if (rf == null) {
            return;
        }
        model2=(DefaultTableModel)receivingFormItemsTable.getModel();
        model2.setRowCount(0);
        List<DetailedReceivingForm> view = em.createNamedQuery("DetailedReceivingForm.findByReceivingId")
        .setParameter("receivingId", rf.getReceivingId())
        .getResultList();
        for (DetailedReceivingForm d : view) {
            model2.addRow(new Object[]{d.getItems(), d.getReceivingQuantity(), null});// TODO
        }
        em = null;
    }//GEN-LAST:event_ReceivingFormsListValueChanged

    private void confirmSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmSelectedActionPerformed
        if (DeliveriesList.getSelectedIndex() == -1) {
            return;
        }
        em = emf.createEntityManager();
        RequestOfItems df = (RequestOfItems) DeliveriesList.getSelectedValue();
        RequestOfItems dfed = (RequestOfItems) em.createNamedQuery("RequestOfItems.findByRequestId")
        .setParameter("requestId", df.getRequestId())
        .getSingleResult();
        em.getTransaction().begin();
        dfed.setAccepted('Y');
        em.getTransaction().commit();
        updateState();
        em = null;
    }//GEN-LAST:event_confirmSelectedActionPerformed

    private void confirmAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAllActionPerformed
        em = emf.createEntityManager();
        Vector <RequestOfItems> dfv = (Vector<RequestOfItems>) em.createNamedQuery("RequestOfItems.findByAccepted")
        .setParameter("accepted", 'N')
        .getResultList();
        if (dfv.size() == 0) {
            Message.setText("All requests were already accepted");
        }
        em.getTransaction().begin();
        for (RequestOfItems df : dfv) {
            df.setAccepted('Y');
        }
        em.getTransaction().commit();
        updateState();
        Message.setText("All requests accepted");
    }//GEN-LAST:event_confirmAllActionPerformed

    private void DeleteDeliveredItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteDeliveredItemActionPerformed
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
            DeliveryForm roi = (DeliveryForm) DeliveriesList.getSelectedValue();
            DetailedDelivery droi = (DetailedDelivery) em.createNamedQuery("DetailedDelivery.findByDeliveryIdAndItemID")
            .setParameter("deliveryId", roi.getDeliveryId())
            .setParameter("itemId", selecteditem.getItemId())
            .getSingleResult();
            em.getTransaction().begin();
            em.remove(droi);
            em.getTransaction().commit();
            model2.removeRow(selectedrow);
            if (ItemsTable2.getRowCount() == 0) {
                DeleteDeliveryActionPerformed(evt);
            }
            Message.setText("Delete Successful");
            em = null;
        }//else
    }//GEN-LAST:event_DeleteDeliveredItemActionPerformed

    private void DeleteDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteDeliveryActionPerformed
        em = emf.createEntityManager();
        if (DeliveriesList.getSelectedIndex() == -1) {
            Message.setText("No Delivery To Delete");
            return;
        }
        DeliveryForm roi = (DeliveryForm) DeliveriesList.getSelectedValue();
        DeliveryForm roitd = (DeliveryForm) em.createNamedQuery("DeliveryForm.findByDeliveryId")
        .setParameter("deliveryId", roi.getDeliveryId())
        .getSingleResult();
        em.getTransaction().begin();
        em.remove(roitd);
        em.getTransaction().commit();
        updateState();
        em = null;
        Message.setText("Delete Successful");
    }//GEN-LAST:event_DeleteDeliveryActionPerformed

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
        DeliveryForm roi = (DeliveryForm) DeliveriesList.getSelectedValue();
        DetailedDelivery droi = (DetailedDelivery) em.createNamedQuery("DetailedDelivery.findByDeliveryIdAndItemID")
        .setParameter("deliveryId", roi.getDeliveryId())
        .setParameter("itemId", selecteditem.getItemId())
        .getSingleResult();
        int newQuantity = Integer.parseInt(JOptionPane.showInputDialog("Enter The New Quantity"));
        em.getTransaction().begin();
        droi.setDeliveredQuantity(newQuantity);
        em.getTransaction().commit();
        model2.setValueAt(newQuantity, selectedrow, 1);
        em = null;
        Message.setText("Edit Successful");
        updateState();
    }//GEN-LAST:event_EditQuantityActionPerformed

    private void departments3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departments3ActionPerformed
        em = emf.createEntityManager();
        if (departments3.getSelectedIndex()==-1) return;
        Departments dep = (Departments) em.createNamedQuery("Departments.findByDeptName")
                .setParameter("deptName", departments3.getSelectedItem())
                .getSingleResult();
        List<NeededItemsPerDept> needDept = em.createNamedQuery("NeededItemsPerDept.findByDeptId")
                .setParameter("deptId", dep.getDeptId())
                .getResultList();
        model1 = (DefaultTableModel) pendingItemsDept.getModel();
        model1.setRowCount(0);
        for (NeededItemsPerDept n:needDept){
            model1.addRow(new Object[]{n.getItemId(), Integer.parseInt(n.getItemId().getAvailableQuantity()),n.getNeededQuantity().intValue()});
        }
        em=null;
    }//GEN-LAST:event_departments3ActionPerformed

    private void AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemActionPerformed
        model1 = (DefaultTableModel)pendingItemsDept.getModel();
        model2 = (DefaultTableModel)ItemsTable2.getModel();
        int selectedRow = pendingItemsDept.getSelectedRow();
        if (selectedRow==-1){
            Message.setText("No Item Selected");
            return;
        }
        Items itemtba = (Items)model1.getValueAt(selectedRow, 0);
        for (int i =0; i<model2.getRowCount(); i++){
            if(model2.getValueAt(i, 0)==itemtba){
                Message.setText("Item Already Added");
                return;
            }
        }
        
        int avquantity =  (int) model1.getValueAt(selectedRow, 1);
        int nquantity =  (int)model1.getValueAt(selectedRow, 2);
        if (avquantity>=0){
        model2.addRow(new Object[]{model1.getValueAt(selectedRow, 0),avquantity>nquantity? nquantity :avquantity});
        }
        else{
            Message.setText("We Don't have any of this to deliver");
        }
    }//GEN-LAST:event_AddItemActionPerformed

    private void DeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemActionPerformed
        // TODO add your handling code here:
        model1=(DefaultTableModel) ItemsTable2.getModel();
        if (this.ItemsTable2.getSelectedRow() == -1) {
            if (ItemsTable2.getRowCount() == 0) {
                Message.setText("Table Is Empty");
            } else {
                Message.setText("No Items Selected");
            }
        } else {
            model1.removeRow(ItemsTable2.getSelectedRow());
            Message.setText("Item Deleted");
        }
    }//GEN-LAST:event_DeleteItemActionPerformed

    private void deliverRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliverRequestActionPerformed
        if (departments3.getSelectedIndex()==-1) return;
        Departments dep = (Departments) em.createNamedQuery("Departments.findByDeptName")
                .setParameter("deptName", departments3.getSelectedItem())
                .getSingleResult();
        model1 = (DefaultTableModel) ItemsTable2.getModel();
        if (model1.getRowCount() == 0) {
            Message.setText("No Items to deliver");
            return;
        }
        em = emf.createEntityManager();
        DeliveryForm req = new DeliveryForm();
        req.setDeptId(dep);
        req.setDeliveryDate(new Date());
        req.setConfirmed('N');
        em.getTransaction().begin();
        em.persist(req);
        DetailedDelivery dreq;
        Items selectedItem;
        for (int i = 0; i < model1.getRowCount(); i++) {
            dreq = new DetailedDelivery();
            selectedItem = (Items) model1.getValueAt(i, 0);
            dreq.setDetailedDeliveryPK(new DetailedDeliveryPK(req.getDeliveryId(), selectedItem.getItemId()));
            Integer sth = Integer.parseInt(model1.getValueAt(i, 1).toString());
            dreq.setDeliveredQuantity(sth);
            em.persist(dreq);
            dreq = null;
        }
        em.getTransaction().commit();
        em = null;
        model1.setRowCount(0);
        Message.setText("Delivery Successful");
        updateState();
    }//GEN-LAST:event_deliverRequestActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItem;
    private javax.swing.JTable AllItemsTable;
    private javax.swing.JButton DeleteDeliveredItem;
    private javax.swing.JButton DeleteDelivery;
    private javax.swing.JButton DeleteItem;
    private javax.swing.JList DeliveriesList;
    private javax.swing.JPanel DeliveriesTab;
    private javax.swing.JButton EditQuantity;
    private javax.swing.JTable ItemsTable2;
    private javax.swing.JTable ItemsTableDeliveries;
    private javax.swing.JTable ItemsTableRequests;
    private javax.swing.JPanel ManageReqestsTab;
    private javax.swing.JPanel ManageReqestsTab1;
    private javax.swing.JPanel PendingItemsTab;
    private javax.swing.JList ReceivingFormsList;
    private javax.swing.JList RequestsList1;
    private javax.swing.JTabbedPane StorPane;
    private javax.swing.JPanel ViewItems;
    private javax.swing.JButton confirmAll;
    private javax.swing.JButton confirmSelected;
    private javax.swing.JButton deliverRequest;
    private javax.swing.JComboBox departments1;
    private javax.swing.JComboBox departments2;
    private javax.swing.JComboBox departments3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable pendingItemsDept;
    private javax.swing.JTable pendingItemsTable;
    private javax.swing.JTable receivingFormItemsTable;
    private javax.swing.JPanel receivingForms;
    private javax.swing.JScrollPane scrol2;
    private javax.swing.JScrollPane scrol5;
    private javax.swing.JComboBox suppliersReceiving;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel Message;
    private WebPopOver pop;

    void updateState() {
        emf.getCache().evictAll();
        em = emf.createEntityManager();
        allItems = em.createNamedQuery("Items.findAll")
                .getResultList();
        model1 = (DefaultTableModel) AllItemsTable.getModel();
        model1.setRowCount(0);
        for (Items it : allItems) {
            model1.addRow(new Object[]{it, it.getAvailableQuantity()});
        }

        model1 = (DefaultTableModel) pendingItemsTable.getModel();
        model1.setRowCount(0);
        List<UndeliveredItems> alluitems = (List< UndeliveredItems>) em.createNamedQuery("UndeliveredItems.findAll")
                .getResultList();
        model1.setRowCount(0);
        for (UndeliveredItems ui : alluitems) {
            model1.addRow(new Object[]{em.find(Items.class, ui.getItemId()), ui.getNeededQuantity()});
        }

        v2 = new Vector();
        allrequests = em.createNamedQuery("RequestOfItems.findAll").getResultList();
        for (RequestOfItems r : allrequests) {
            v2.add(r);
        }
        RequestsList1.setListData(v2);
        em = null;
    }
    void initState(){
                em = emf.createEntityManager();
        List<Suppliers> allSuppliers = em.createNamedQuery("Suppliers.findAll")
                .getResultList();
        DefaultComboBoxModel cmodel1 = (DefaultComboBoxModel) (suppliersReceiving.getModel());
        cmodel1.removeAllElements();
        cmodel1.addElement("All Suppliers");
        for (Suppliers sup : allSuppliers) {
            cmodel1.addElement(sup.getSupplierName());
        }
        
        List<Departments> allDepts = em.createNamedQuery("Departments.findAll")
                .getResultList();
        DefaultComboBoxModel cmodel4 = (DefaultComboBoxModel) (departments1.getModel());
        DefaultComboBoxModel cmodel5 = (DefaultComboBoxModel) (departments2.getModel());
        DefaultComboBoxModel cmodel6 = (DefaultComboBoxModel) (departments3.getModel());
        cmodel4.removeAllElements();
        cmodel5.removeAllElements();
        cmodel6.removeAllElements();
        cmodel4.addElement("All Departments");
        cmodel5.addElement("All Departments");
        for (Departments dept : allDepts) {
            cmodel4.addElement(dept.getDeptName());
            cmodel5.addElement(dept.getDeptName());
            cmodel6.addElement(dept.getDeptName());
        }
    }
}
