/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.crisma.objecteditors;

import Sirius.navigator.connection.SessionManager;
import Sirius.navigator.types.treenode.ObjectTreeNode;
import Sirius.navigator.ui.ComponentRegistry;
import Sirius.navigator.ui.RequestsFullSizeComponent;

import Sirius.server.middleware.types.MetaClass;
import Sirius.server.middleware.types.MetaObject;
import Sirius.server.middleware.types.MetaObjectNode;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.Box.Filler;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.plaf.LayerUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

import de.cismet.cids.custom.crisma.AbstractCidsBeanRenderer;
import de.cismet.cids.custom.crisma.BorderPanel;
import de.cismet.cids.custom.crisma.ScenarioView;
import de.cismet.cids.custom.crisma.Tools;
import de.cismet.cids.custom.crisma.tostringconverter.WorldstatesToStringConverter;
import de.cismet.cids.custom.crisma.worldstate.editor.DetailEditor;
import de.cismet.cids.custom.crisma.worldstate.viewer.DetailView;

import de.cismet.cids.dynamics.CidsBean;

import de.cismet.cids.navigator.utils.ClassCacheMultiple;

import de.cismet.tools.gui.StaticSwingTools;
import de.cismet.tools.gui.TitleComponentProvider;

/**
 * DOCUMENT ME!
 *
 * @author   mscholl
 * @version  $Revision$, $Date$
 */
public class WorldstatesEditor extends AbstractCidsBeanRenderer implements RequestsFullSizeComponent,
    TitleComponentProvider {

    //~ Static fields/initializers ---------------------------------------------

    /** LOGGER. */
    private static final transient Logger LOG = LoggerFactory.getLogger(WorldstatesEditor.class);

    //~ Instance fields --------------------------------------------------------

    private final transient ImageIcon saveIcon32;
    private final transient ImageIcon leafIcon32;
    private final transient ImageIcon worldIcon32;

    private transient boolean editing;

    private final WorldstatesToStringConverter conv;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlSwapper;
    private javax.swing.JPanel pnlTreepath;
    private javax.swing.JPanel pnlWorldstate;
    private javax.swing.JScrollPane scrSwapper;
    // End of variables declaration//GEN-END:variables

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form WorldstateRenderer.
     */
    public WorldstatesEditor() {
        this(true);
    }

    /**
     * Creates a new WorldstatesEditor object.
     *
     * @param  editing  DOCUMENT ME!
     */
    public WorldstatesEditor(final boolean editing) {
        this.editing = editing;
        this.conv = new WorldstatesToStringConverter();

        initComponents();

        saveIcon32 = ImageUtilities.loadImageIcon(WorldstatesEditor.class.getPackage().getName().replaceAll("\\.", "/")
                        + "/world_save_32.png",
                false);
        worldIcon32 = ImageUtilities.loadImageIcon(WorldstatesEditor.class.getPackage().getName().replaceAll("\\.", "/")
                        + "/world_32.png",
                false);
        leafIcon32 = ImageUtilities.loadImageIcon(WorldstatesEditor.class.getPackage().getName().replaceAll("\\.", "/")
                        + "/world_leaf_32.png",
                false);
        jLabel1.setIconTextGap(8);
        scrSwapper.getViewport().setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        StaticSwingTools.setNiftyScrollBars(scrSwapper);
        StaticSwingTools.setNiftyScrollBars(jScrollPane1);
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlWorldstate = new javax.swing.JPanel();
        jSplitPane1 = new TransparentDivider();
        pnlDetails = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        scrSwapper = new javax.swing.JScrollPane();
        pnlSwapper = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlTreepath = new javax.swing.JPanel();

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));                                             // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(NbBundle.getMessage(WorldstatesEditor.class, "WorldstatesEditor.jLabel1.text")); // NOI18N
        jPanel2.add(jLabel1, java.awt.BorderLayout.WEST);

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        pnlWorldstate.setOpaque(false);
        pnlWorldstate.setLayout(new java.awt.GridBagLayout());

        jSplitPane1.setBorder(null);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(0.7);
        jSplitPane1.setToolTipText(NbBundle.getMessage(
                WorldstatesEditor.class,
                "WorldstatesEditor.jSplitPane1.toolTipText")); // NOI18N
        jSplitPane1.setOpaque(false);

        pnlDetails.setOpaque(false);
        pnlDetails.setLayout(new java.awt.BorderLayout());
        jSplitPane1.setLeftComponent(pnlDetails);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        scrSwapper.setBorder(null);
        scrSwapper.setOpaque(false);

        pnlSwapper.setOpaque(false);
        pnlSwapper.setLayout(new javax.swing.BoxLayout(pnlSwapper, javax.swing.BoxLayout.X_AXIS));
        scrSwapper.setViewportView(pnlSwapper);

        jPanel1.add(scrSwapper, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlWorldstate.add(jSplitPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        add(pnlWorldstate, gridBagConstraints);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        pnlTreepath.setBorder(javax.swing.BorderFactory.createTitledBorder(
                null,
                NbBundle.getMessage(WorldstatesEditor.class, "WorldstatesEditor.pnlTreepath.border.title"),
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                null,
                new java.awt.Color(68, 68, 68))); // NOI18N
        pnlTreepath.setOpaque(false);
        pnlTreepath.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(pnlTreepath);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(jPanel3, gridBagConstraints);
    } // </editor-fold>//GEN-END:initComponents

    @Override
    protected void init() {
        EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    initTreepath();
                    initViewer();
                }
            });

        setTitle(conv.convert(getCidsBean().getMetaObject()));
        jLabel1.setIcon(cidsBean.getBeanCollectionProperty("childworldstates").isEmpty() ? leafIcon32 : worldIcon32);
        jSplitPane1.setDividerLocation(0.7);
    }

    /**
     * DOCUMENT ME!
     */
    private void initTreepath() {
        assert EventQueue.isDispatchThread() : "EDT only";

        final LinkedList<CidsBean> beans = new LinkedList<CidsBean>();
        CidsBean current = cidsBean;

        while (current != null) {
            beans.addFirst(current);
            current = (CidsBean)current.getProperty("parentworldstate");
        }

        for (int i = 0; i < beans.size(); ++i) {
            final JButton b = new JButton(conv.convert(beans.get(i).getMetaObject()));
            b.setBackground(new Color(68, 68, 68, 255));
            b.setFont(new Font("Tahoma", Font.BOLD, 14));
            b.setForeground(Color.white);
            final MetaObject mo = beans.get(i).getMetaObject();
            b.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        if (!mo.equals(WorldstatesEditor.this.cidsBean.getMetaObject())) {
                            final List mos = new ArrayList();
                            mos.add(new ObjectTreeNode(new MetaObjectNode(((MetaObject)mo).getBean())));

                            ComponentRegistry.getRegistry().getDescriptionPane().setNodesDescriptions(mos);
                        }
                    }
                });

            final GridBagConstraints gc1 = new GridBagConstraints(i * 2,
                    0,
                    1,
                    1,
                    0,
                    0,
                    GridBagConstraints.WEST,
                    GridBagConstraints.HORIZONTAL,
                    new Insets(5, 5, 5, 5),
                    0,
                    0);
            final GridBagConstraints gc2 = new GridBagConstraints((i * 2) + 1,
                    0,
                    1,
                    1,
                    0,
                    0,
                    GridBagConstraints.WEST,
                    GridBagConstraints.HORIZONTAL,
                    new Insets(5, 5, 5, 5),
                    0,
                    0);

            pnlTreepath.add(b, gc1);
            pnlTreepath.add(new JLabel(
                    ImageUtilities.loadImageIcon(
                        WorldstatesEditor.class.getPackage().getName().replaceAll("\\.", "/")
                                + "/arrow_16.png",
                        false)),
                gc2);
        }

        pnlTreepath.remove(pnlTreepath.getComponentCount() - 1);
        pnlTreepath.add(new Filler(new Dimension(), new Dimension(), new Dimension()),
            new GridBagConstraints(
                pnlTreepath.getComponentCount()
                        + 2,
                0,
                1,
                1,
                1,
                0,
                GridBagConstraints.WEST,
                GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0),
                0,
                0));
    }

    /**
     * DOCUMENT ME!
     *
     * @throws  IllegalStateException  DOCUMENT ME!
     */
    private void initViewer() {
        assert EventQueue.isDispatchThread() : "EDT only";
        assert !editing : "init while not editing only";

//        final Map<DetailView, DetailEditor> views = new HashMap<>();
        final Map<DetailView, DetailEditor> views = new TreeMap<DetailView, DetailEditor>(new Comparator<DetailView>() {

                    @Override
                    public int compare(final DetailView o1, final DetailView o2) {
                        return o1.getDisplayName().compareTo(o2.getDisplayName());
                    }
                });
        try {
            final MetaClass mcr = ClassCacheMultiple.getMetaClass("CRISMA", "renderingdescriptors");
            final MetaClass mce = ClassCacheMultiple.getMetaClass("CRISMA", "MANIPULATIONDESCRIPTORS");
            final String sqlr = "SELECT " + mcr.getID() + ", r."
                        + mcr.getPrimaryKey()
                        + " FROM renderingdescriptors r, renderingdescriptorscategories rc, categories ca, classifications cl where r.categories = rc.renderingdescriptors_reference and rc.categories = ca.id and ca.classification = cl.id and cl.key like 'worldstate_detail_component'";
            final String sqle = "SELECT " + mce.getID() + ", m." + mce.getPrimaryKey()
                        + " FROM MANIPULATIONDESCRIPTORS m, manipulationdescriptorscategories mc, categories ca, classifications cl where m.categories = mc.manipulationdescriptors_reference and mc.category = ca.id and ca.classification = cl.id and cl.key like 'worldstate_detail_component'";
            final MetaObject[] mosr = SessionManager.getProxy()
                        .getMetaObjectByQuery(SessionManager.getSession().getUser(), sqlr);
            final MetaObject[] mose = SessionManager.getProxy()
                        .getMetaObjectByQuery(SessionManager.getSession().getUser(), sqle);
            final ObjectMapper m = new ObjectMapper(new JsonFactory());
            final TypeReference<Map<String, String>> ref = new TypeReference<Map<String, String>>() {
                };

            for (final MetaObject mo : mosr) {
                final String jsonString = (String)mo.getBean().getProperty("uiintegrationinfo");
                final Map<String, String> json = m.readValue(jsonString, ref);
                final String viewName = json.get("canonicalName");

                final DetailView view = (DetailView)Class.forName(viewName).newInstance();
                view.setDescriptor(mo.getBean());

                DetailEditor editor = null;
                for (final MetaObject moe : mose) {
                    final Object o = moe.getBean().getProperty("categories");
                    if (mo.getBean().getProperty("categories").equals(o)) {
                        final String jsonStringM = (String)moe.getBean().getProperty("uiintegrationinfo");
                        final Map<String, String> jsonM = m.readValue(jsonStringM, ref);
                        final String editorName = jsonM.get("canonicalName");

                        editor = (DetailEditor)Class.forName(editorName).newInstance();
                        editor.setDescriptor(moe.getBean());

                        break;
                    }
                }
                views.put(view, editor);
            }
        } catch (final Exception e) {
//        } catch (ConnectionException | ClassNotFoundException | IOException | InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException("illegal renderingdescriptors configuration", e);
        }

        pnlSwapper.setLayout(new GridLayout(1, views.size() - 1, 10, 0));

        for (final DetailView view : views.keySet()) {
            final BorderPanel p = new BorderPanel();
            final JPanel contentPane = new JPanel(new BorderLayout());
            contentPane.setOpaque(false);
            view.setWorldstate(cidsBean);
            contentPane.putClientProperty("detailView", view);
            contentPane.putClientProperty("detailEditor", views.get(view));
            p.setTitle(view.getDisplayName());
            p.setContentPane(contentPane);

            if ("Shakemaps".equals(view.getDisplayName())) {
                contentPane.add(view.getView(), BorderLayout.CENTER);
                pnlDetails.add(p);
            } else {
                final LayerUI<JComponent> layerUI = new LayerUI<JComponent>() {

                        @Override
                        public void eventDispatched(final AWTEvent awte, final JLayer jlayer) {
                            assert EventQueue.isDispatchThread() : "EDT only";

                            if (MouseEvent.MOUSE_CLICKED == awte.getID()) {
                                final BorderPanel oldContentPane = (BorderPanel)pnlDetails.getComponent(0);
                                final JComponent oc = oldContentPane.getContentPane();
                                final BorderPanel newContentPane = (BorderPanel)jlayer.getView();
                                final JComponent nc = newContentPane.getContentPane();

                                final DetailView oldDetailV = (DetailView)oc.getClientProperty(
                                        "detailView");
                                final DetailEditor oldDetailE = (DetailEditor)oc.getClientProperty(
                                        "detailEditor");
                                final DetailView newDetailV = (DetailView)nc.getClientProperty(
                                        "detailView");
                                final DetailEditor newDetailE = (DetailEditor)nc.getClientProperty(
                                        "detailEditor");

                                oc.removeAll();
                                oc.add(editing ? oldDetailE.getMiniatureEditor() : oldDetailV.getMiniatureView(),
                                    BorderLayout.CENTER);

                                nc.removeAll();
                                nc.add(editing ? newDetailE.getEditor() : newDetailV.getView(),
                                    BorderLayout.CENTER);

                                jlayer.setView(oldContentPane);

                                newContentPane.setVisible(true);
                                pnlDetails.removeAll();
                                pnlDetails.add(newContentPane, BorderLayout.CENTER);
                                pnlDetails.invalidate();
                                pnlDetails.revalidate();
                                pnlDetails.repaint();
                            }
                        }
                    };

                final JLayer<JComponent> layer = new JLayer<JComponent>(p, layerUI);
                layer.setLayerEventMask(Long.MAX_VALUE);
                layer.setOpaque(false);
                contentPane.add(view.getMiniatureView(), BorderLayout.CENTER);
                pnlSwapper.add(layer);
            }
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public boolean isEditing() {
        return editing;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  editing  DOCUMENT ME!
     */
    public void setEditing(final boolean editing) {
        if ((this.editing && editing) || !(this.editing || editing)) {
            return;
        }

        try {
            if (!editing) {
                final int answer = JOptionPane.showConfirmDialog(
                        this,
                        "Do you want to save the changes",
                        "Save changes",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        saveIcon32);
                if (JOptionPane.CANCEL_OPTION == answer) {
                    return;
                } else if (JOptionPane.YES_OPTION == answer) {
                    cidsBean = Tools.saveWorldstate(
                            ((DetailEditor)(((BorderPanel)pnlDetails.getComponent(0)).getContentPane())
                                        .getClientProperty("detailEditor")).getWorldstate());

                    StaticSwingTools.getParentFrame(this).invalidate();
                    StaticSwingTools.getParentFrame(this).validate();
                    StaticSwingTools.getParentFrame(this).repaint();

                    this.editing = editing;

                    Tools.reloadCatalogTree();
                    ScenarioView.getInstance().updateLeafs();
                    final List mos = new ArrayList(1);
                    mos.add(new ObjectTreeNode(new MetaObjectNode(cidsBean)));

                    ComponentRegistry.getRegistry().getDescriptionPane().setNodesDescriptions(mos);

                    return;
                }
            }
            final CidsBean copy = SessionManager.getProxy()
                        .getMetaObject(cidsBean.getMetaObject().getID() + "@" + cidsBean.getMetaObject().getClassKey())
                        .getBean();

            for (final Component c : pnlSwapper.getComponents()) {
                final JPanel miniature = ((BorderPanel)((JLayer)c).getView()).getContentPane();
                miniature.removeAll();
                final DetailView v = (DetailView)miniature.getClientProperty("detailView");
                final DetailEditor e = (DetailEditor)miniature.getClientProperty("detailEditor");

                if (LOG.isDebugEnabled()) {
                    LOG.debug("setediting=" + editing + "|detailview=" + v + "|detaileditor=" + e);
                }

                if (editing) {
                    e.setWorldstate(copy);
                    miniature.add(e.getMiniatureEditor(), BorderLayout.CENTER);
                } else {
                    v.setWorldstate(cidsBean);
                    miniature.add(v.getMiniatureView(), BorderLayout.CENTER);
                }
            }

            final JPanel detail = ((BorderPanel)pnlDetails.getComponent(0)).getContentPane();
            detail.removeAll();
            final DetailEditor e = (DetailEditor)detail.getClientProperty("detailEditor");
            final DetailView v = (DetailView)detail.getClientProperty("detailView");
            if (editing) {
                e.setWorldstate(copy);
                detail.add(e.getEditor(), BorderLayout.CENTER);
            } else {
                v.setWorldstate(cidsBean);
                detail.add(v.getView(), BorderLayout.CENTER);
            }

            for (final Component c : pnlTreepath.getComponents()) {
                c.setEnabled(!editing);
            }

            StaticSwingTools.getParentFrame(this).invalidate();
            StaticSwingTools.getParentFrame(this).validate();
            StaticSwingTools.getParentFrame(this).repaint();

            this.editing = editing;
        } catch (final Exception exception) {
            LOG.error("cannot change edit status", exception);
        }
    }

    @Override
    public JComponent getTitleComponent() {
        return jPanel2;
    }

    @Override
    public void setTitle(final String title) {
        jLabel1.setText(title);
    }

    @Override
    public String getTitle() {
        return jLabel1.getText();
    }

    //~ Inner Classes ----------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @version  $Revision$, $Date$
     */
    private static final class TransparentDivider extends JSplitPane {

        //~ Methods ------------------------------------------------------------

        @Override
        public void updateUI() {
            setUI(new SplitPaneWithZeroSizeDividerUI());
            revalidate();
        }

        //~ Inner Classes ------------------------------------------------------

        /**
         * DOCUMENT ME!
         *
         * @version  $Revision$, $Date$
         */
        private class SplitPaneWithZeroSizeDividerUI extends BasicSplitPaneUI {

            //~ Methods --------------------------------------------------------

            @Override
            public BasicSplitPaneDivider createDefaultDivider() {
                return new ZeroSizeDivider(this);
            }
        }
        /**
         * DOCUMENT ME!
         *
         * @version  $Revision$, $Date$
         */
        private class ZeroSizeDivider extends BasicSplitPaneDivider {

            //~ Constructors ---------------------------------------------------

            /**
             * Creates a new ZeroSizeDivider object.
             *
             * @param  ui  DOCUMENT ME!
             */
            public ZeroSizeDivider(final BasicSplitPaneUI ui) {
                super(ui);
                super.setBorder(null);
                setBackground(new Color(255, 255, 255, 0));
            }

            //~ Methods --------------------------------------------------------

            @Override
            public void setBorder(final Border border) {
                // ignore
            }

            @Override
            public void paint(final Graphics g) {
                g.setColor(getBackground());
                if (orientation == HORIZONTAL_SPLIT) {
                    g.drawLine(0, 0, 0, getHeight() - 1);
                } else {
                    g.drawLine(0, 0, getWidth() - 1, 0);
                }
            }
        }
    }
}
