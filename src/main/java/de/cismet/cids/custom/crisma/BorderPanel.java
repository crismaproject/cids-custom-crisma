/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.crisma;

import org.openide.util.NbBundle;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import de.cismet.tools.gui.SemiRoundedPanel.Orientation;

/**
 * DOCUMENT ME!
 *
 * @author   mscholl
 * @version  $Revision$, $Date$
 */
public class BorderPanel extends javax.swing.JPanel {

    //~ Instance fields --------------------------------------------------------

    private transient JPanel contentPane;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private de.cismet.tools.gui.RoundedPanel roundedPanel1;
    private de.cismet.tools.gui.SemiRoundedPanel semiRoundedPanel1;
    private de.cismet.tools.gui.SemiRoundedPanel semiRoundedPanel2;
    // End of variables declaration//GEN-END:variables

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form BorderPanel.
     */
    public BorderPanel() {
        initComponents();

        semiRoundedPanel2.setCurveLocation(Orientation.SOUTH);
        contentPane = jPanel1;
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param  title  DOCUMENT ME!
     */
    public void setTitle(final String title) {
        jLabel1.setText(title);
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public String getTitle() {
        return jLabel1.getText();
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public JPanel getContentPane() {
        return contentPane;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  contentPane  DOCUMENT ME!
     */
    public void setContentPane(final JPanel contentPane) {
        roundedPanel1.remove(this.contentPane);
        this.contentPane = contentPane;
        roundedPanel1.add(this.contentPane, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        roundedPanel1 = new de.cismet.tools.gui.RoundedPanel();
        semiRoundedPanel1 = new de.cismet.tools.gui.SemiRoundedPanel();
        jLabel1 = new javax.swing.JLabel();
        semiRoundedPanel2 = new de.cismet.tools.gui.SemiRoundedPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        semiRoundedPanel1.setBackground(new java.awt.Color(68, 68, 68));
        semiRoundedPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));                                 // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(NbBundle.getMessage(BorderPanel.class, "BorderPanel.jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        semiRoundedPanel1.add(jLabel1, gridBagConstraints);

        roundedPanel1.add(semiRoundedPanel1, java.awt.BorderLayout.NORTH);

        semiRoundedPanel2.setBackground(new java.awt.Color(68, 68, 68));
        semiRoundedPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));                                 // NOI18N
        jLabel2.setForeground(new java.awt.Color(68, 68, 68));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(NbBundle.getMessage(BorderPanel.class, "BorderPanel.jLabel2.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        semiRoundedPanel2.add(jLabel2, gridBagConstraints);

        roundedPanel1.add(semiRoundedPanel2, java.awt.BorderLayout.SOUTH);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());
        roundedPanel1.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(roundedPanel1, java.awt.BorderLayout.CENTER);
    } // </editor-fold>//GEN-END:initComponents
}
