/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.crisma.objectrenderer;

import org.openide.util.NbBundle;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Path2D;

import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import de.cismet.tools.gui.jbands.BandModelEvent;
import de.cismet.tools.gui.jbands.interfaces.BandModelListener;

/**
 * DOCUMENT ME!
 *
 * @author   mscholl
 * @version  $Revision$, $Date$
 */
public final class IndicatorBandPostfix extends javax.swing.JPanel implements BandModelListener {

    //~ Instance fields --------------------------------------------------------

    private IndicatorBand band;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel lblIndValue;
    private JLabel lblLos;
    private JPanel pnlUBound;
    // End of variables declaration//GEN-END:variables

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form IndicatorBandPrefix.
     *
     * @param  band  DOCUMENT ME!
     */
    public IndicatorBandPostfix(final IndicatorBand band) {
        initComponents();

        setBand(band);
        ((UpperBoundPanel)pnlUBound).updateIndValue();
        band.getModel().addBandModelListener(this);
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public IndicatorBand getBand() {
        return band;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  band  DOCUMENT ME!
     */
    public void setBand(final IndicatorBand band) {
        this.band = band;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        pnlUBound = new UpperBoundPanel();
        lblLos = new JLabel();
        lblIndValue = new JLabel();

        setLayout(new GridBagLayout());

        pnlUBound.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlUBound.setMinimumSize(new Dimension(80, 24));
        pnlUBound.setOpaque(false);
        pnlUBound.setPreferredSize(new Dimension(80, 24));
        pnlUBound.setLayout(new GridBagLayout());

        lblLos.setFont(new Font("Lucida Grande", 0, 9));                                                     // NOI18N
        lblLos.setText(NbBundle.getMessage(IndicatorBandPostfix.class, "IndicatorBandPostfix.lblLos.text")); // NOI18N
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(1, 4, 0, 0);
        pnlUBound.add(lblLos, gridBagConstraints);

        lblIndValue.setFont(new Font("Lucida Grande", 0, 9));                                                          // NOI18N
        lblIndValue.setText(NbBundle.getMessage(IndicatorBandPostfix.class, "IndicatorBandPostfix.lblIndValue.text")); // NOI18N
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 4, 1, 0);
        pnlUBound.add(lblIndValue, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 2, 0, 0);
        add(pnlUBound, gridBagConstraints);
    } // </editor-fold>//GEN-END:initComponents

    @Override
    public void bandModelChanged(final BandModelEvent e) {
        bandModelValuesChanged(e);
    }

    @Override
    public void bandModelSelectionChanged(final BandModelEvent e) {
        // noop
    }

    @Override
    public void bandModelValuesChanged(final BandModelEvent e) {
        ((UpperBoundPanel)pnlUBound).updateIndValue();
    }

    //~ Inner Classes ----------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @version  $Revision$, $Date$
     */
    private final class UpperBoundPanel extends JPanel implements MouseListener {

        //~ Constructors -------------------------------------------------------

        /**
         * Creates a new UpperBoundPanel object.
         */
        public UpperBoundPanel() {
            addMouseListener(this);
        }

        //~ Methods ------------------------------------------------------------

        @Override
        protected void paintComponent(final Graphics g) {
            super.paintComponent(g);

            final Graphics2D g2 = (Graphics2D)g.create();

            final int w = getWidth() - 1;
            final int h = 23;

            final Path2D.Float path = new Path2D.Float();
            path.moveTo(w, 0);
            path.lineTo(0, 0);
            path.lineTo(0, h);
            path.lineTo(w, h);
            path.lineTo(w - 3, 29);
            path.lineTo(w, 15);
            path.lineTo(w - 3, 11);
            path.lineTo(w, 7);
            path.lineTo(w - 3, 3);
            path.lineTo(w, 0);
            path.closePath();

            g2.setColor(IndicatorBand.getBandColor(2, 1));
            g2.fill(path);
            g2.setColor(Color.BLACK);
            g2.drawLine(w, 0, 0, 0);
            g2.drawLine(0, 0, 0, h);
            g2.drawLine(0, h, w, h);

            g2.dispose();
        }

        @Override
        public void setSize(final Dimension d) {
            super.setSize(new Dimension((d.width < 24) ? 24 : d.width, 24));
        }

        @Override
        public void setSize(final int width, final int height) {
            super.setSize((width < 24) ? 24 : width, 24);
        }

        @Override
        public void setMinimumSize(final Dimension d) {
            super.setMinimumSize(new Dimension((d.width < 24) ? 24 : d.width, 24));
        }

        @Override
        public void setMaximumSize(final Dimension d) {
            super.setMaximumSize(new Dimension((d.width < 24) ? 24 : d.width, 24));
        }

        @Override
        public void setPreferredSize(final Dimension d) {
            super.setPreferredSize(new Dimension((d.width < 24) ? 24 : d.width, 24));
        }

        @Override
        public void mouseClicked(final MouseEvent e) {
            if (!e.isPopupTrigger() && WorldstatesAggregationRenderer._critEditing) {
                JOptionPane.showMessageDialog(
                    this,
                    new CriteriaBoundaryPopup(band.getHundredGroup(), true),
                    "Criteria Bounds",
                    JOptionPane.PLAIN_MESSAGE,
                    null);
                band.getModel().fireBandModelChanged();
            }
        }

        @Override
        public void mousePressed(final MouseEvent e) {
            // noop
        }

        @Override
        public void mouseReleased(final MouseEvent e) {
            // noop
        }

        @Override
        public void mouseEntered(final MouseEvent e) {
            setCursor(WorldstatesAggregationRenderer._critEditing ? Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
                                                                  : Cursor.getDefaultCursor());
        }

        @Override
        public void mouseExited(final MouseEvent e) {
            // noop
        }

        /**
         * DOCUMENT ME!
         */
        public void updateIndValue() {
            lblIndValue.setText(((band.getHundredGroup().getValue() > band.getZeroGroup().getValue()) ? ">= " : "<= ")
                        + NumberFormat.getNumberInstance().format(band.getHundredGroup().getValue()));
            this.setToolTipText("Indicator value: "
                        + NumberFormat.getNumberInstance().format(band.getHundredGroup().getValue())
                        + " "
                        + band.getHundredGroup().getUnit());
        }
    }
}
