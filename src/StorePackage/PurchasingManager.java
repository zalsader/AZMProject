/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StorePackage;

import static StorePackage.DeptUI.con;
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
public class PurchasingManager extends javax.swing.JFrame implements WindowListener {

    EntityManagerFactory emf = null;
    EntityManager em = null;
    DefaultTableModel model;
    DefaultTableModel model2;
    DefaultTableModel model3;
    DefaultTableModel model4;
    
    static Connection con;
    static Statement stmt;
    static String username = "AZM";
    static String password = "azm";
    static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    ResultSet rs;
    Vector v;
    Vector v2;
    Vector v3;
    Vector newitemsvector ;
  //  Vector v4;
    List<Items> allItems;
    List<Suppliers> allsuppliers;
    List<RequestOfItems> allrequests;
 //   List<DeliveryForm> alldeliveries;
  //  List<RequestOfItems> deptrequests;
  //  int viewedRequest = -1;
    boolean isDelivered = false;
    public PurchasingManager() {
        initComponents();
        setTitle("Purchasing Manager UI");
        emf = Persistence.createEntityManagerFactory("AZMprojectPU");
        em = emf.createEntityManager();
        model = new DefaultTableModel();
        model = (DefaultTableModel) this.BuyOrderItems.getModel();
        model2 = new DefaultTableModel();
        model2 = (DefaultTableModel) this.AllItemsTable.getModel();
        model3 = new DefaultTableModel();
        model3 = (DefaultTableModel) AllSuppliers.getModel();
        model4 = new DefaultTableModel();
        model4 = (DefaultTableModel) this.RequestsTable.getModel();
        
        Query qr = em.createNamedQuery("Items.findAll");
        allItems = qr.getResultList();
        v = new Vector();
        for (Items i : allItems) {
            v.add(i.getItemName());
            model2.addRow(new Object[]{i.getItemName(),i.getItemUnit()});
        }
        this.ItemsList.setListData(v);
        
        allsuppliers = em.createNamedQuery("Suppliers.findAll").getResultList();
        Suppliers.removeAllItems();
        for (Suppliers sp : allsuppliers) {
           Suppliers.addItem(sp.getSupplierName());
           model3.addRow(new Object[]{sp.getSupplierName(),sp.getSupplierAddress(),sp.getPhoneNo(),sp.getFaxNo()});
        }
        v2 = new Vector();
        allrequests = em.createNamedQuery("RequestOfItems.findAll").getResultList();
        for (RequestOfItems r : allrequests) {
            v2.add(r.getRequestId());
        }
        RequestsList.setListData(v2);
        
        
        //
        //v4 = new Vector();
        //allrequests = em.createNamedQuery("RequestOfItems.findAll").getResultList();
        //for (RequestOfItems r : allrequests) {
          //  if(r.getDeptId().getDeptId()==CurDeptartmentID){
            //v2.add(r.getRequestId());
           // v4.add(r);
            //}
        //}
       // deptrequests.addAll(allrequests);
        //RequestsList.setListData(v2);
        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DeptUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        newitemsvector = new Vector();
        //
        //alldeliveries = em.createNamedQuery("DeliveryForm.findAll").getResultList();
        //RequestOfItems roi = new RequestOfItems();
        //for (DeliveryForm df : alldeliveries) {
          //  for(int i =0;i<v4.size();i++){
            //    roi = (RequestOfItems) v4.get(i);
              //  if(roi.getRequestId()==df.getRequestId().getRequestId())
                //v3.add(df.getDeliveryId());
            //}
        //}
        //this.DeliveriesList.setListData(v3);
        
        //EditQuantity.setEnabled(false);
        //DeleteRequestedItem.setEnabled(false);
        //DeleteRequest.setEnabled(false);
        em = null;
        addWindowListener(this);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DeptPane = new javax.swing.JTabbedPane();
        BuyOrder = new javax.swing.JPanel();
        ManageReqests = new javax.swing.JPanel();
        AddItem = new javax.swing.JButton();
        scrol1 = new javax.swing.JScrollPane();
        BuyOrderItems = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        ItemsList = new javax.swing.JList();
        Message = new javax.swing.JLabel();
        DeleteItem = new javax.swing.JButton();
        Purchase = new javax.swing.JButton();
        Suppliers = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        ViewItems = new javax.swing.JPanel();
        scrol2 = new javax.swing.JScrollPane();
        AllItemsTable = new javax.swing.JTable();
        AddNewItem = new javax.swing.JButton();
        ViewSuppliers = new javax.swing.JPanel();
        scrol3 = new javax.swing.JScrollPane();
        AllSuppliers = new javax.swing.JTable();
        AddNewSupplier = new javax.swing.JButton();
        ViewRequests = new javax.swing.JPanel();
        ManageReqestsTab1 = new javax.swing.JPanel();
        ViewRequest1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        RequestsTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        RequestsList = new javax.swing.JList();
        Message3 = new javax.swing.JLabel();
        ViewBuyOrders = new javax.swing.JPanel();
        ManageReqestsTab = new javax.swing.JPanel();
        EditQuantity = new javax.swing.JButton();
        ViewRequest = new javax.swing.JButton();
        scrol = new javax.swing.JScrollPane();
        BuyOrderItems2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        ItemsLists2 = new javax.swing.JList();
        Message2 = new javax.swing.JLabel();
        DeleteRequestedItem = new javax.swing.JButton();
        DeleteRequest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Purchasing Manager");
        setResizable(false);

        BuyOrder.setName(""); // NOI18N

        AddItem.setText("Add Item");
        AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemActionPerformed(evt);
            }
        });

        BuyOrderItems.setModel(new javax.swing.table.DefaultTableModel(
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
        scrol1.setViewportView(BuyOrderItems);
        if (BuyOrderItems.getColumnModel().getColumnCount() > 0) {
            BuyOrderItems.getColumnModel().getColumn(0).setHeaderValue("Item ID");
            BuyOrderItems.getColumnModel().getColumn(2).setHeaderValue("Quantity");
        }

        ItemsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Items Available"));
        ItemsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ItemsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ItemsListValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(ItemsList);

        DeleteItem.setText("Delete Item");
        DeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteItemActionPerformed(evt);
            }
        });

        Purchase.setText("Purchase");
        Purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseActionPerformed(evt);
            }
        });

        Suppliers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Choose Supplier:");

        javax.swing.GroupLayout ManageReqestsLayout = new javax.swing.GroupLayout(ManageReqests);
        ManageReqests.setLayout(ManageReqestsLayout);
        ManageReqestsLayout.setHorizontalGroup(
            ManageReqestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageReqestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrol1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                    .addGroup(ManageReqestsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(ManageReqestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageReqestsLayout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(ManageReqestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(AddItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DeleteItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ManageReqestsLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Suppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Message, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ManageReqestsLayout.setVerticalGroup(
            ManageReqestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageReqestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageReqestsLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageReqestsLayout.createSequentialGroup()
                        .addComponent(AddItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteItem)
                        .addGap(33, 33, 33)
                        .addComponent(Purchase)
                        .addGap(25, 25, 25)))
                .addGroup(ManageReqestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Suppliers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(Message, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrol1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BuyOrderLayout = new javax.swing.GroupLayout(BuyOrder);
        BuyOrder.setLayout(BuyOrderLayout);
        BuyOrderLayout.setHorizontalGroup(
            BuyOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuyOrderLayout.createSequentialGroup()
                .addComponent(ManageReqests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        BuyOrderLayout.setVerticalGroup(
            BuyOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuyOrderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ManageReqests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DeptPane.addTab("Purchase Items", BuyOrder);

        scrol2.setPreferredSize(new java.awt.Dimension(400, 350));

        AllItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Unit Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrol2.setViewportView(AllItemsTable);
        if (AllItemsTable.getColumnModel().getColumnCount() > 0) {
            AllItemsTable.getColumnModel().getColumn(1).setHeaderValue("Unit Type");
        }

        AddNewItem.setText("Add New Item");
        AddNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewItemsLayout = new javax.swing.GroupLayout(ViewItems);
        ViewItems.setLayout(ViewItemsLayout);
        ViewItemsLayout.setHorizontalGroup(
            ViewItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrol2, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE))
            .addGroup(ViewItemsLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(AddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ViewItemsLayout.setVerticalGroup(
            ViewItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrol2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        DeptPane.addTab("View Items", ViewItems);

        scrol3.setPreferredSize(new java.awt.Dimension(400, 350));

        AllSuppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier Name", "Address", "Phone No.", "FAX No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrol3.setViewportView(AllSuppliers);

        AddNewSupplier.setText("Add New Supplier");
        AddNewSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewSuppliersLayout = new javax.swing.GroupLayout(ViewSuppliers);
        ViewSuppliers.setLayout(ViewSuppliersLayout);
        ViewSuppliersLayout.setHorizontalGroup(
            ViewSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSuppliersLayout.createSequentialGroup()
                .addGroup(ViewSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewSuppliersLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(scrol3, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ViewSuppliersLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(AddNewSupplier)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        ViewSuppliersLayout.setVerticalGroup(
            ViewSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrol3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddNewSupplier)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        DeptPane.addTab("View Suppliers", ViewSuppliers);

        ViewRequest1.setText("View Request");
        ViewRequest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewRequest1ActionPerformed(evt);
            }
        });

        RequestsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(RequestsTable);

        RequestsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Requests Available"));
        RequestsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        RequestsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                RequestsListValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(RequestsList);

        javax.swing.GroupLayout ManageReqestsTab1Layout = new javax.swing.GroupLayout(ManageReqestsTab1);
        ManageReqestsTab1.setLayout(ManageReqestsTab1Layout);
        ManageReqestsTab1Layout.setHorizontalGroup(
            ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Message3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ViewRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 295, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ManageReqestsTab1Layout.setVerticalGroup(
            ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                        .addComponent(ViewRequest1)
                        .addGap(36, 36, 36)
                        .addComponent(Message3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ViewRequestsLayout = new javax.swing.GroupLayout(ViewRequests);
        ViewRequests.setLayout(ViewRequestsLayout);
        ViewRequestsLayout.setHorizontalGroup(
            ViewRequestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
            .addGroup(ViewRequestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewRequestsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ManageReqestsTab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ViewRequestsLayout.setVerticalGroup(
            ViewRequestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
            .addGroup(ViewRequestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewRequestsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ManageReqestsTab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        DeptPane.addTab("View Requests", ViewRequests);

        javax.swing.GroupLayout ViewBuyOrdersLayout = new javax.swing.GroupLayout(ViewBuyOrders);
        ViewBuyOrders.setLayout(ViewBuyOrdersLayout);
        ViewBuyOrdersLayout.setHorizontalGroup(
            ViewBuyOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
        );
        ViewBuyOrdersLayout.setVerticalGroup(
            ViewBuyOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );

        DeptPane.addTab("View Buy Orders", ViewBuyOrders);

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

        BuyOrderItems2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Items", "Quantity", "Unit Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrol.setViewportView(BuyOrderItems2);

        ItemsLists2.setBorder(javax.swing.BorderFactory.createTitledBorder("Items Available"));
        ItemsLists2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ItemsLists2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ItemsLists2ValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(ItemsLists2);

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
                    .addComponent(scrol, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(EditQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ViewRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DeleteRequestedItem, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DeleteRequest)))
                            .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Message2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        ManageReqestsTabLayout.setVerticalGroup(
            ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageReqestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ManageReqestsTabLayout.createSequentialGroup()
                        .addComponent(ViewRequest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteRequestedItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteRequest)
                        .addGap(11, 11, 11)
                        .addComponent(Message2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrol, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        DeptPane.addTab("Manage Requests", ManageReqestsTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DeptPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeptPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRequestActionPerformed

    }//GEN-LAST:event_DeleteRequestActionPerformed

    private void DeleteRequestedItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRequestedItemActionPerformed

    }//GEN-LAST:event_DeleteRequestedItemActionPerformed

    private void ItemsLists2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ItemsLists2ValueChanged

    }//GEN-LAST:event_ItemsLists2ValueChanged

    private void ViewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewRequestActionPerformed

    }//GEN-LAST:event_ViewRequestActionPerformed

    private void EditQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditQuantityActionPerformed

    }//GEN-LAST:event_EditQuantityActionPerformed

    private void RequestsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_RequestsListValueChanged
        Message2.setText("");
        Message3.setText("");
        em = emf.createEntityManager();
        Integer selectedItem = (Integer) RequestsList.getSelectedValue();
        List<DeliveryForm> allDelivered = em.createNamedQuery("DeliveryForm.findAll").getResultList();
        for(DeliveryForm df:allDelivered)
        if(df.getRequestId().getRequestId()==selectedItem)
        {isDelivered = true;
            Message3.setText("Request is Delivered");
            em = null;
            return;}
        else{
            Message3.setText("Request is not Delivered");
            isDelivered = false;
        }
        em = null;
    }//GEN-LAST:event_RequestsListValueChanged

    private void ViewRequest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewRequest1ActionPerformed
        Message2.setText("");
        if (RequestsList.getSelectedIndex() == -1) {
            Message2.setText("No Request Selected");
            return;
        }
        em = emf.createEntityManager();
        Integer selectedItem = (Integer) RequestsList.getSelectedValue();
        //   viewedRequest = selectedItem;
        model4.setRowCount(0);
        List<DetailedRequestOfItems> view = em.createNamedQuery("DetailedRequestOfItems.findAll").getResultList();
        for (DetailedRequestOfItems d : view) {
            if (d.getDetailedRequestOfItemsPK().getRequestId() == selectedItem) {
                for (Items vi : allItems) {
                    if (d.getDetailedRequestOfItemsPK().getItemId() == vi.getItemId()) {
                        try {
                            model4.addRow(new Object[]{vi.getItemName(), d.getRequestedQuantity()});
                        } catch (Exception e) {
                            System.out.println("");
                        }//catch
                    }//if
                }//for
            }//if
        }//for
        em = null;
    }//GEN-LAST:event_ViewRequest1ActionPerformed

    private void AddNewSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewSupplierActionPerformed
        // TODO add your handling code here:
        String SupplierName,Address,Phone,Fax;
        int SupplierID = 0;

        SupplierName = JOptionPane.showInputDialog("Enter The Name Of The New Supplier:");
        if(SupplierName == null) return;
        for (Suppliers sp : allsuppliers) {
            if(sp.getSupplierName().equalsIgnoreCase(SupplierName)){JOptionPane.showMessageDialog(this, "This Supplier Already Exists");return;}
        }
        Address = JOptionPane.showInputDialog("Enter The Address:");
        if(Address == null) return;
        Phone = JOptionPane.showInputDialog("Enter The Phone Number:");
        if(Phone == null) return;
        Fax = JOptionPane.showInputDialog("Enter The Fax Number:");
        if(Fax == null) return;
        em = emf.createEntityManager();
        try {
            rs = stmt.executeQuery("select max(Supplier_ID) from Suppliers");
            rs.next();
            SupplierID = rs.getInt(1) + 1;
        } catch (SQLException ex) {
            Logger.getLogger(PurchasingManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        Suppliers supplier = new Suppliers();
        supplier.setSupplierName(SupplierName);
        supplier.setSupplierAddress(Address);
        supplier.setPhoneNo(Phone);
        supplier.setFaxNo(Fax);
        this.model3.addRow(new Object[]{SupplierName,Address,Phone,Fax});
        em.getTransaction().begin();
        em.persist(supplier);
        em.getTransaction().commit();
        em = null;
        supplier = null;

    }//GEN-LAST:event_AddNewSupplierActionPerformed

    private void AddNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewItemActionPerformed
        // TODO add your handling code here:
        String ItemName;
        String Unit = "unit";
        int ItemID = 0;
        ItemName = JOptionPane.showInputDialog("Enter The Name Of The New Item:");
        if(ItemName == null) return;
        for (Items i : allItems) {
            if(i.getItemName().equalsIgnoreCase(ItemName)){JOptionPane.showMessageDialog(this, "This Item Already Exists");return;}
        }
        Unit = JOptionPane.showInputDialog("Enter The Unit Type:");
        if(Unit == null) return;
        em = emf.createEntityManager();
        try {
            rs = stmt.executeQuery("select max(Item_ID) from Items");
            rs.next();
            ItemID = rs.getInt(1) + 1;
        } catch (SQLException ex) {
            Logger.getLogger(DeptUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        Items item = new Items();
        item.setItemName(ItemName);
        item.setItemUnit(Unit);
        item.setItemId(ItemID);
        this.model2.addRow(new Object[]{ItemName,Unit});
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        em = null;
        item = null;

    }//GEN-LAST:event_AddNewItemActionPerformed

    private void PurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseActionPerformed
        // TODO add your handling code here:
        if (model.getRowCount() == 0) {
            Message.setText("No Items to purchase");
            return;
        }
        em = emf.createEntityManager();
        BuyOrder buy = new BuyOrder();
        ReceivingForm receive = new ReceivingForm();
        buy.setOrderDate(new Date());
        String SupplierName = (String)Suppliers.getSelectedItem();
        //System.out.println(SupplierName);
        int supplierID=0;
        for (Suppliers sp : allsuppliers)
        if(sp.getSupplierName().equals(SupplierName))supplierID = sp.getSupplierId();
        buy.setSupplierId(new Suppliers(supplierID));
        int curBuyOrder = 0;
        try {
            rs = stmt.executeQuery("select max(Order_ID) from Buy_Order");
            rs.next();
            curBuyOrder = rs.getInt(1) + 1;
        } catch (SQLException ex) {
            Logger.getLogger(DeptUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        buy.setOrderId(curBuyOrder);
        em.getTransaction().begin();
        em.persist(buy);
        em.getTransaction().commit();
        em = null;
        /* don't forget to add it to the buyorder list

        RequestsList.removeAll();
        v2.add(curRequestID);
        RequestsList.setListData(v2);
        */
        DetailedBuyOrder dbuy;
        String ItemName;
        int curItemID;
        List<Items> selectedItem;
        for (int i = 0; i < model.getRowCount(); i++) {
            curItemID=0;
            em = emf.createEntityManager();
            dbuy = new DetailedBuyOrder();
            ItemName = (String) model.getValueAt(i, 0);
            //System.out.println(ItemName);
            selectedItem = em.createNamedQuery("Items.findAll").getResultList();
            for (Items si : selectedItem)
            if (si.getItemName().equals(ItemName))
            curItemID = si.getItemId();
            //System.out.println(curItemID);
            dbuy.setDetailedBuyOrderPK(new DetailedBuyOrderPK(curBuyOrder, curItemID));
            // System.out.println(dbuy.getDetailedBuyOrderPK().getItemId()+"and"+dbuy.getDetailedBuyOrderPK().getOrderId());
            dbuy.setBuyQuantity((Integer)model.getValueAt(i, 1));
            //   System.out.println(model.getValueAt(i, 1));
            dbuy.setUnitPrice((Integer)model.getValueAt(i, 2));
            //    System.out.println(model.getValueAt(i, 2));

            em.getTransaction().begin();
            em.persist(dbuy);
            em.getTransaction().commit();
            em = null;
            dbuy = null;
        }
        model.setRowCount(0);
        Message.setText("Purchase Successful");
    }//GEN-LAST:event_PurchaseActionPerformed

    private void DeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemActionPerformed
        // TODO add your handling code here:
        Message.setText("");
        if (this.BuyOrderItems.getSelectedRow() == -1) {
            if (BuyOrderItems.getRowCount() == 0) {
                Message.setText("Table Is Empty");
            } else {
                Message.setText("No Items Selected");
            }
        } else {
            try {
                model.removeRow(BuyOrderItems.getSelectedRow());
                Message.setText("Item Deleted");
            } catch (Exception e) {
                System.out.printf("");
            }
        }
    }//GEN-LAST:event_DeleteItemActionPerformed

    private void ItemsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ItemsListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemsListValueChanged

    private void AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemActionPerformed
        // TODO add your handling code here:
        Message.setText("");
        String selectedItem="";
        if (ItemsList.getSelectedIndex() != -1) {
            selectedItem = (String) ItemsList.getSelectedValue();
            for (int i = 0; i < model.getRowCount(); i++) {
                if (selectedItem.equals((String) model.getValueAt(i, 0))) {
                    Message.setText("Already added");
                    return;
                }
            }
            try {
                model.addRow(new Object[]{selectedItem, "1","1"});
                ItemsList.clearSelection();
            } catch (Exception e) {
                System.out.print("");
            }
        }
        else {
            Message.setText("No Item Selected");}
        return;
    }//GEN-LAST:event_AddItemActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItem;
    private javax.swing.JButton AddNewItem;
    private javax.swing.JButton AddNewSupplier;
    private javax.swing.JTable AllItemsTable;
    private javax.swing.JTable AllSuppliers;
    private javax.swing.JPanel BuyOrder;
    private javax.swing.JTable BuyOrderItems;
    private javax.swing.JTable BuyOrderItems2;
    private javax.swing.JButton DeleteItem;
    private javax.swing.JButton DeleteRequest;
    private javax.swing.JButton DeleteRequestedItem;
    private javax.swing.JTabbedPane DeptPane;
    private javax.swing.JButton EditQuantity;
    private javax.swing.JList ItemsList;
    private javax.swing.JList ItemsLists2;
    private javax.swing.JPanel ManageReqests;
    private javax.swing.JPanel ManageReqestsTab;
    private javax.swing.JPanel ManageReqestsTab1;
    private javax.swing.JLabel Message;
    private javax.swing.JLabel Message2;
    private javax.swing.JLabel Message3;
    private javax.swing.JButton Purchase;
    private javax.swing.JList RequestsList;
    private javax.swing.JTable RequestsTable;
    private javax.swing.JComboBox Suppliers;
    private javax.swing.JPanel ViewBuyOrders;
    private javax.swing.JPanel ViewItems;
    private javax.swing.JButton ViewRequest;
    private javax.swing.JButton ViewRequest1;
    private javax.swing.JPanel ViewRequests;
    private javax.swing.JPanel ViewSuppliers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane scrol;
    private javax.swing.JScrollPane scrol1;
    private javax.swing.JScrollPane scrol2;
    private javax.swing.JScrollPane scrol3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent we) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        emf.close();
    }

    @Override
    public void windowClosed(WindowEvent we) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
