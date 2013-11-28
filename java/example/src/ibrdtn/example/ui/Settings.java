package ibrdtn.example.ui;

import ibrdtn.api.APIException;
import ibrdtn.example.api.APIHandlerType;
import ibrdtn.example.api.PayloadType;
import ibrdtn.example.api.DTNClient;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Settings dialog.
 *
 * @author Julian Timpner <timpner@ibr.cs.tu-bs.de>
 */
public class Settings extends JDialog {

    private static final Logger logger = Logger.getLogger(Settings.class.getName());
    private DTNExampleApp dtnApp;

    public Settings(JFrame parent) {

        super(parent, true);

        initComponents();
        pack();

        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        // Center in the parent
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
        dtnApp = (DTNExampleApp) parent;

        cbAPIType.setSelectedItem(dtnApp.getDtnClient().getApiType());
        cbPayloadType.setSelectedItem(dtnApp.getDtnClient().getPayloadType());
        cbAutoResponse.setSelected(DTNExampleApp.isAutoResponse);
        if (dtnApp.getDtnClient().getPayloadType().equals(PayloadType.BYTE)) {
            cbAutoResponse.setEnabled(false);
        }

        try {
            dtnApp.getDtnClient().getEC().getNodeName();
            String node = dtnApp.getDtnClient().getEC().getNodeName().toString();
            String eid = dtnApp.getDtnClient().getEC().getEndpoint().toString();
            eid = eid.replaceAll(node + "/", "");
            tfEndpoint.setText(eid);
        } catch (APIException ex) {
            logger.log(Level.WARNING, "Failed to get EID");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        cbPayloadType = new javax.swing.JComboBox();
        cbAPIType = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbEvents = new javax.swing.JCheckBox();
        btnSave = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfEndpoint = new javax.swing.JTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 80), new java.awt.Dimension(0, 80), new java.awt.Dimension(32767, 80));
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        jLabel6 = new javax.swing.JLabel();
        cbAutoResponse = new javax.swing.JCheckBox();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 12, 12));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        closeButton.setMnemonic('C');
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        mainPanel.add(closeButton, gridBagConstraints);

        cbPayloadType.setModel(new DefaultComboBoxModel(PayloadType.values()));
        cbPayloadType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPayloadTypeItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPanel.add(cbPayloadType, gridBagConstraints);

        cbAPIType.setModel(new DefaultComboBoxModel(APIHandlerType.values()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPanel.add(cbAPIType, gridBagConstraints);

        jLabel2.setText("Payload type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPanel.add(jLabel2, gridBagConstraints);

        jLabel3.setText("API type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPanel.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Events:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPanel.add(jLabel4, gridBagConstraints);

        cbEvents.setText("Enabled");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPanel.add(cbEvents, gridBagConstraints);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        mainPanel.add(btnSave, gridBagConstraints);

        jLabel5.setText("Primary EID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPanel.add(jLabel5, gridBagConstraints);

        tfEndpoint.setText("client-1");
        tfEndpoint.setMinimumSize(new java.awt.Dimension(60, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPanel.add(tfEndpoint, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        mainPanel.add(filler2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        mainPanel.add(filler1, gridBagConstraints);

        jLabel6.setText("Auto-Response:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPanel.add(jLabel6, gridBagConstraints);

        cbAutoResponse.setText("Enabled");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPanel.add(cbAutoResponse, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(mainPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        dtnApp.getDtnClient().shutdown();

        // Auto-response for object type payloads
        DTNExampleApp.isAutoResponse = cbAutoResponse.isSelected();

        dtnApp.PRIMARY_EID = tfEndpoint.getText();
        dtnApp.PAYLOAD_TYPE = (PayloadType) cbPayloadType.getSelectedItem();
        dtnApp.HANDLER_TYPE = (APIHandlerType) cbAPIType.getSelectedItem();

        DTNClient dtnClient = new DTNClient(dtnApp.PRIMARY_EID, dtnApp.PAYLOAD_TYPE, dtnApp.HANDLER_TYPE);
        dtnApp.setDtnClient(dtnClient);

        if (cbEvents.isSelected()) {
            dtnApp.getDtnClient().setEvents(true);
            logger.log(Level.INFO, "Event notifications enabled.");
        } else {
            dtnApp.getDtnClient().setEvents(false);
            logger.log(Level.INFO, "Event notifications disabled.");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbPayloadTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPayloadTypeItemStateChanged
        if (evt.getItem().equals(PayloadType.OBJECT) && evt.getStateChange() == ItemEvent.SELECTED) {
            cbAutoResponse.setEnabled(true);
        } else if (evt.getItem().equals(PayloadType.BYTE) && evt.getStateChange() == ItemEvent.SELECTED) {
            logger.log(Level.INFO, "Auto-response is only available with Payload Type Object.");
            cbAutoResponse.setEnabled(false);
        }
    }//GEN-LAST:event_cbPayloadTypeItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbAPIType;
    private javax.swing.JCheckBox cbAutoResponse;
    private javax.swing.JCheckBox cbEvents;
    private javax.swing.JComboBox cbPayloadType;
    private javax.swing.JButton closeButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField tfEndpoint;
    // End of variables declaration//GEN-END:variables
}