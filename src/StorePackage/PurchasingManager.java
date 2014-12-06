/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StorePackage;


import com.alee.extended.window.WebPopOver;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author  Zuhair MahmoodKhalid
 */
public class PurchasingManager extends javax.swing.JFrame {

    EntityManagerFactory emf = null;
    EntityManager em = null;
    DefaultTableModel model1;
    DefaultTableModel model2;
    
    public PurchasingManager() {
        initComponents();
        setTitle("Purchasing Manager");
        emf = Persistence.createEntityManagerFactory("AZMprojectPU");
        em = emf.createEntityManager();
        
        message = new JLabel();
        pop = new WebPopOver(this);
        pop.setCloseOnFocusLoss(true);
        pop.add(message);
        pop.setMargin(15);
        message.addPropertyChangeListener("text", new PropertyChangeListener() {
            
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                pop.show(PurchasingManager.this);
            }
        });
        
        initLists();
        updateState();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        purchPane = new javax.swing.JTabbedPane();
        BuyOrder = new javax.swing.JPanel();
        scrol1 = new javax.swing.JScrollPane();
        purchaseItems = new javax.swing.JTable();
        suppliersPurchase = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        AddItem = new javax.swing.JButton();
        Purchase = new javax.swing.JButton();
        DeleteItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsNeededForPurchase = new javax.swing.JTable();
        ViewItems = new javax.swing.JPanel();
        scrol2 = new javax.swing.JScrollPane();
        AllItemsTable = new javax.swing.JTable();
        AddNewItem = new javax.swing.JButton();
        editItem = new javax.swing.JButton();
        removeItem = new javax.swing.JButton();
        ViewSuppliers = new javax.swing.JPanel();
        scrol3 = new javax.swing.JScrollPane();
        AllSuppliers = new javax.swing.JTable();
        AddNewSupplier = new javax.swing.JButton();
        editSupplier = new javax.swing.JButton();
        removeSupplier = new javax.swing.JButton();
        ViewBuyOrders = new javax.swing.JPanel();
        scrol4 = new javax.swing.JScrollPane();
        buyOrderItems = new javax.swing.JTable();
        suppliersBuyOrders = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        buyOredersList = new javax.swing.JList();
        receivingForms = new javax.swing.JPanel();
        scrol5 = new javax.swing.JScrollPane();
        receivingFormItemsTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        suppliersReceiving = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        ReceivingFormsList = new javax.swing.JList();
        DeliveriesTab = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ItemsTableDeliveries = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        DeliveriesList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        departments1 = new javax.swing.JComboBox();
        ManageReqestsTab1 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        ItemsTableRequests = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        RequestsList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        departments2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Purchasing Manager");
        setIconImage(new ImageIcon(getClass().getResource("/StorePackage/zakat.jpg")).getImage());
        setResizable(false);

        BuyOrder.setName(""); // NOI18N

        purchaseItems.setModel(new javax.swing.table.DefaultTableModel(
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
        scrol1.setViewportView(purchaseItems);
        if (purchaseItems.getColumnModel().getColumnCount() > 0) {
            purchaseItems.getColumnModel().getColumn(0).setHeaderValue("Item ID");
            purchaseItems.getColumnModel().getColumn(2).setHeaderValue("Quantity");
        }

        suppliersPurchase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Choose Supplier:");

        AddItem.setText("Add Item");
        AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemActionPerformed(evt);
            }
        });

        Purchase.setText("Proceed To Order");
        Purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseActionPerformed(evt);
            }
        });

        DeleteItem.setText("Delete Item");
        DeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteItemActionPerformed(evt);
            }
        });

        itemsNeededForPurchase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Availabe Quantity", "Quantity Needed"
            }
        ));
        jScrollPane1.setViewportView(itemsNeededForPurchase);

        javax.swing.GroupLayout BuyOrderLayout = new javax.swing.GroupLayout(BuyOrder);
        BuyOrder.setLayout(BuyOrderLayout);
        BuyOrderLayout.setHorizontalGroup(
            BuyOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuyOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BuyOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(scrol1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuyOrderLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suppliersPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                        .addComponent(AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuyOrderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Purchase)))
                .addContainerGap())
        );
        BuyOrderLayout.setVerticalGroup(
            BuyOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuyOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BuyOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteItem)
                    .addComponent(AddItem)
                    .addComponent(suppliersPurchase)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrol1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Purchase)
                .addContainerGap())
        );

        purchPane.addTab("Purchase", BuyOrder);

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
        if (AllItemsTable.getColumnModel().getColumnCount() > 0) {
            AllItemsTable.getColumnModel().getColumn(1).setHeaderValue("Unit Type");
        }

        AddNewItem.setText("Add New Item");
        AddNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewItemActionPerformed(evt);
            }
        });

        editItem.setText("Edit Item");

        removeItem.setText("Remove Item");

        javax.swing.GroupLayout ViewItemsLayout = new javax.swing.GroupLayout(ViewItems);
        ViewItems.setLayout(ViewItemsLayout);
        ViewItemsLayout.setHorizontalGroup(
            ViewItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewItemsLayout.createSequentialGroup()
                        .addGap(0, 369, Short.MAX_VALUE)
                        .addComponent(removeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editItem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrol2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ViewItemsLayout.setVerticalGroup(
            ViewItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddNewItem)
                    .addComponent(editItem)
                    .addComponent(removeItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrol2, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
        );

        purchPane.addTab("Items", ViewItems);

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

        editSupplier.setText("Edit Supplier");
        editSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSupplierActionPerformed(evt);
            }
        });

        removeSupplier.setText("Remove Supplier");

        javax.swing.GroupLayout ViewSuppliersLayout = new javax.swing.GroupLayout(ViewSuppliers);
        ViewSuppliers.setLayout(ViewSuppliersLayout);
        ViewSuppliersLayout.setHorizontalGroup(
            ViewSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrol3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ViewSuppliersLayout.createSequentialGroup()
                        .addGap(0, 365, Short.MAX_VALUE)
                        .addComponent(removeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AddNewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ViewSuppliersLayout.setVerticalGroup(
            ViewSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddNewSupplier)
                    .addComponent(editSupplier)
                    .addComponent(removeSupplier))
                .addGap(11, 11, 11)
                .addComponent(scrol3, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
        );

        purchPane.addTab("Suppliers", ViewSuppliers);

        buyOrderItems.setModel(new javax.swing.table.DefaultTableModel(
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
        scrol4.setViewportView(buyOrderItems);
        if (buyOrderItems.getColumnModel().getColumnCount() > 0) {
            buyOrderItems.getColumnModel().getColumn(0).setHeaderValue("Item ID");
            buyOrderItems.getColumnModel().getColumn(2).setHeaderValue("Quantity");
        }

        suppliersBuyOrders.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Choose Supplier:");

        buyOredersList.setBorder(javax.swing.BorderFactory.createTitledBorder("Buy Orderes Available"));
        buyOredersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        buyOredersList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                buyOredersListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(buyOredersList);

        javax.swing.GroupLayout ViewBuyOrdersLayout = new javax.swing.GroupLayout(ViewBuyOrders);
        ViewBuyOrders.setLayout(ViewBuyOrdersLayout);
        ViewBuyOrdersLayout.setHorizontalGroup(
            ViewBuyOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewBuyOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewBuyOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrol4, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(ViewBuyOrdersLayout.createSequentialGroup()
                        .addGroup(ViewBuyOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewBuyOrdersLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(suppliersBuyOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ViewBuyOrdersLayout.setVerticalGroup(
            ViewBuyOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewBuyOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewBuyOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suppliersBuyOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrol4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        purchPane.addTab("Buy Orders", ViewBuyOrders);

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
        if (receivingFormItemsTable.getColumnModel().getColumnCount() > 0) {
            receivingFormItemsTable.getColumnModel().getColumn(0).setHeaderValue("Item ID");
            receivingFormItemsTable.getColumnModel().getColumn(2).setHeaderValue("Quantity");
        }

        jLabel4.setText("Choose Supplier:");

        suppliersReceiving.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ReceivingFormsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Receiving Forms Available"));
        ReceivingFormsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ReceivingFormsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ReceivingFormsListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ReceivingFormsList);
        ReceivingFormsList.getAccessibleContext().setAccessibleName("Receiving Forms Available");

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrol5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        purchPane.addTab("Receiving forms", receivingForms);

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
        jScrollPane8.setViewportView(ItemsTableDeliveries);

        DeliveriesList.setBorder(javax.swing.BorderFactory.createTitledBorder("Deliveries Available"));
        DeliveriesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        DeliveriesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                DeliveriesListValueChanged(evt);
            }
        });
        jScrollPane9.setViewportView(DeliveriesList);

        jLabel3.setText("Choose Department:");

        departments1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout DeliveriesTabLayout = new javax.swing.GroupLayout(DeliveriesTab);
        DeliveriesTab.setLayout(DeliveriesTabLayout);
        DeliveriesTabLayout.setHorizontalGroup(
            DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveriesTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(DeliveriesTabLayout.createSequentialGroup()
                        .addGroup(DeliveriesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DeliveriesTabLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(departments1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        purchPane.addTab("Deliveries", DeliveriesTab);

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
        jScrollPane10.setViewportView(ItemsTableRequests);

        RequestsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Requests Available"));
        RequestsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        RequestsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                RequestsListValueChanged(evt);
            }
        });
        jScrollPane11.setViewportView(RequestsList);

        jLabel2.setText("Choose Department:");

        departments2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout ManageReqestsTab1Layout = new javax.swing.GroupLayout(ManageReqestsTab1);
        ManageReqestsTab1.setLayout(ManageReqestsTab1Layout);
        ManageReqestsTab1Layout.setHorizontalGroup(
            ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                        .addGroup(ManageReqestsTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ManageReqestsTab1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(departments2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        purchPane.addTab("Requests", ManageReqestsTab1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(purchPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(purchPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void DeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemActionPerformed
        // TODO add your handling code here:
        message.setText("");
        if (this.purchaseItems.getSelectedRow() == -1) {
            if (purchaseItems.getRowCount() == 0) {
                message.setText("Table Is Empty");
            } else {
                message.setText("No Items Selected");
            }
        } else {
            try {
                model.removeRow(purchaseItems.getSelectedRow());
                message.setText("Item Deleted");
            } catch (Exception e) {
                System.out.printf("");
            }
        }
    }//GEN-LAST:event_DeleteItemActionPerformed

    private void PurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseActionPerformed
        // TODO add your handling code here:
        if (model.getRowCount() == 0) {
            message.setText("No Items to purchase");
            return;
        }
        em = emf.createEntityManager();
        BuyOrder buy = new BuyOrder();
        ReceivingForm receive = new ReceivingForm();
        buy.setOrderDate(new Date());
        String SupplierName = (String)suppliersPurchase.getSelectedItem();
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
        message.setText("Purchase Successful");
    }//GEN-LAST:event_PurchaseActionPerformed

    private void AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemActionPerformed
        // TODO add your handling code here:
        message.setText("");
        String selectedItem="";
        if (ItemsList.getSelectedIndex() != -1) {
            selectedItem = (String) ItemsList.getSelectedValue();
            for (int i = 0; i < model.getRowCount(); i++) {
                if (selectedItem.equals((String) model.getValueAt(i, 0))) {
                    message.setText("Already added");
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
            message.setText("No Item Selected");}
        return;
    }//GEN-LAST:event_AddItemActionPerformed

    private void buyOredersListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_buyOredersListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_buyOredersListValueChanged

    private void ReceivingFormsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ReceivingFormsListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ReceivingFormsListValueChanged

    private void editSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editSupplierActionPerformed

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
    private javax.swing.JButton DeleteItem;
    private javax.swing.JList DeliveriesList;
    private javax.swing.JPanel DeliveriesTab;
    private javax.swing.JTable ItemsTableDeliveries;
    private javax.swing.JTable ItemsTableRequests;
    private javax.swing.JPanel ManageReqestsTab1;
    private javax.swing.JButton Purchase;
    private javax.swing.JList ReceivingFormsList;
    private javax.swing.JList RequestsList;
    private javax.swing.JPanel ViewBuyOrders;
    private javax.swing.JPanel ViewItems;
    private javax.swing.JPanel ViewSuppliers;
    private javax.swing.JTable buyOrderItems;
    private javax.swing.JList buyOredersList;
    private javax.swing.JComboBox departments1;
    private javax.swing.JComboBox departments2;
    private javax.swing.JButton editItem;
    private javax.swing.JButton editSupplier;
    private javax.swing.JTable itemsNeededForPurchase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane purchPane;
    private javax.swing.JTable purchaseItems;
    private javax.swing.JTable receivingFormItemsTable;
    private javax.swing.JPanel receivingForms;
    private javax.swing.JButton removeItem;
    private javax.swing.JButton removeSupplier;
    private javax.swing.JScrollPane scrol1;
    private javax.swing.JScrollPane scrol2;
    private javax.swing.JScrollPane scrol3;
    private javax.swing.JScrollPane scrol4;
    private javax.swing.JScrollPane scrol5;
    private javax.swing.JComboBox suppliersBuyOrders;
    private javax.swing.JComboBox suppliersPurchase;
    private javax.swing.JComboBox suppliersReceiving;
    // End of variables declaration//GEN-END:variables
    private JLabel message;
    private WebPopOver pop;
  void updateState() {
      em=emf.createEntityManager();
      List<ToBePurchased> allToBePurchased = em.createNamedQuery("ToBePurchased.findAll")
              .getResultList();
      model1 = (DefaultTableModel)itemsNeededForPurchase.getModel();
      model1.setRowCount(0);
      for (ToBePurchased tbp :allToBePurchased){
          model1.addRow(new Object[]{em.find(Items.class, tbp.getItemId()),tbp.getQuantityNeeded(), tbp.getQuantityNeeded()});
      }
      
      List<Items> allItems = em.createNamedQuery("Items.findAll")
              .getResultList();
      model1 = (DefaultTableModel)AllItemsTable.getModel();
      model1.setRowCount(0);
      for (Items it: allItems){
          model1.addRow(new Object[]{it, it.getAvailableQuantity()});
      }
      
  }

    private void initLists() {
        em=emf.createEntityManager();
        List <Suppliers> allSuppliers =  em.createNamedQuery("Suppliers.findAll")
                .getResultList();
        DefaultComboBoxModel cmodel1 = (DefaultComboBoxModel)(suppliersPurchase.getModel());
        DefaultComboBoxModel cmodel2 = (DefaultComboBoxModel)(suppliersBuyOrders.getModel());
        cmodel1.removeAllElements();
        cmodel2.removeAllElements();
        cmodel2.addElement("All Suppliers");
        for (Suppliers sup: allSuppliers){
            cmodel1.addElement(sup.getSupplierName());
            cmodel2.addElement(sup.getSupplierName());
        }
        suppliersBuyOrders.setModel(cmodel2);
        suppliersPurchase.setModel(cmodel1);
        suppliersReceiving.setModel(cmodel2);
        
        List<Departments> allDepts = em.createNamedQuery("Departments.findAll")
                .getResultList();
        DefaultComboBoxModel cmodel3 = (DefaultComboBoxModel)(departments1.getModel());
        cmodel3.removeAllElements();
        cmodel3.addElement("All Departments");
        for (Departments dept: allDepts){
            cmodel3.addElement(dept.getDeptName());
        }
        
        
    }
}
//         Connection conn;
//        InputStream input;
//        JasperDesign jasperDesign;
//        JasperReport jasperReport;
//        JasperPrint jasperPrint;
//        OutputStream output;
//        OracleDataSource ods;
//        try{
//            ods=new OracleDataSource();
//            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
//            ods.setUser("AZM");
//            ods.setPassword("azm");
//            conn=ods.getConnection();
//            
//            input=new FileInputStream(new File("add URL for irepot form"));
//            jasperDesign=JRXmlLoader.load(input);
//            jasperReport=JasperCompileManager.compileReport(jasperDesign);
//            jasperPrint=JasperFillManager.fillReport(jasperReport,null,conn);
//            output=new FileOutputStream(new File("were to save the file "));
//            JasperExportManager.exportReportToPdfStream(jasperPrint,output);
//            output.flush();
//            input.close();
//            output.close();
//            JOptionPane.showmessageDialog(null, "All Saved to PDF!!");
//            
//        }catch(Exception ex)
//        {
//            JOptionPane.showmessageDialog(null,ex.toString());
//        }