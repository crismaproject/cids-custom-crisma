/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.crisma.worldstate.editor;

import org.openide.util.ImageUtilities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

/**
 * DOCUMENT ME!
 *
 * @author   mscholl
 * @version  $Revision$, $Date$
 */
public abstract class NotEditableEditor extends AbstractDetailEditor {

    //~ Instance fields --------------------------------------------------------

    private final transient BufferedImage image256;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form NotEditableEditor.
     */
    public NotEditableEditor() {
        initComponents();

        final Image i = ImageUtilities.loadImage(NotEditableEditor.class.getPackage().getName().replaceAll("\\.", "/")
                        + "/edit-not-validated_256.png");
        image256 = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g2 = image256.createGraphics();
        g2.drawImage(i, 0, 0, this);
        g2.dispose();
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setLayout(new java.awt.BorderLayout());
    } // </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public JComponent getEditor() {
        return this;
    }

    @Override
    public JComponent getMiniatureEditor() {
        return this;
    }

    @Override
    public void paintComponent(final Graphics g) {
        final int iw = getSize().width * 2 / 3;
        final int ih = getSize().height * 2 / 3;

        final int scale = Math.min(iw, ih);

        final int h = (getSize().height - scale) / 2;
        final int w = (getSize().width - scale) / 2;
        g.drawImage(getScaledInstance(image256, scale, scale, RenderingHints.VALUE_INTERPOLATION_BICUBIC, true),
            w,
            h,
            this);
        g.dispose();
    }

    /**
     * https://today.java.net/pub/a/today/2007/04/03/perils-of-image-getscaledinstance.html
     *
     * @param   img            DOCUMENT ME!
     * @param   targetWidth    DOCUMENT ME!
     * @param   targetHeight   DOCUMENT ME!
     * @param   hint           DOCUMENT ME!
     * @param   higherQuality  DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public BufferedImage getScaledInstance(final BufferedImage img,
            final int targetWidth,
            final int targetHeight,
            final Object hint,
            final boolean higherQuality) {
        final int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB
                                                                        : BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = img;
        int w;
        int h;
        if (higherQuality) {
            // Use multi-step technique: start with original size, then
            // scale down in multiple passes with drawImage()
            // until the target size is reached
            w = img.getWidth();
            h = img.getHeight();
        } else {
            // Use one-step technique: scale directly from original
            // size to target size with a single drawImage() call
            w = targetWidth;
            h = targetHeight;
        }

        do {
            if (higherQuality && (w > targetWidth)) {
                w /= 2;
                if (w < targetWidth) {
                    w = targetWidth;
                }
            }

            if (higherQuality && (h > targetHeight)) {
                h /= 2;
                if (h < targetHeight) {
                    h = targetHeight;
                }
            }

            final BufferedImage tmp = new BufferedImage(w, h, type);
            final Graphics2D g2 = tmp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
            g2.drawImage(ret, 0, 0, w, h, null);
            g2.dispose();

            ret = tmp;
        } while ((w != targetWidth) || (h != targetHeight));

        return ret;
    }
}
