package View.MainPanel;

import java.awt.Dimension;
import java.io.File;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import Control.CLectureSelection;
import ValueObject.LectureVO;

public class LDirectory extends JPanel {
	private static final long serialVersionUID = 1L;
	private String root;
	private String selectednodeName;
	private JTree tree;
	
	private CLectureSelection cLectureSelection;
	private String filepath;
	private File lecturefile;
	
	public LDirectory() {
		// set Design
		this.cLectureSelection = new CLectureSelection();
		
		// set Logic
		getFileRoot();
        File rootDirectory = new File(root);
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(new FileNode(rootDirectory));
        this.tree = new JTree(rootNode);
        this.tree.setShowsRootHandles(true);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent event) {
                DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode)
                tree.getLastSelectedPathComponent();
                FileNode fileNode = (FileNode)dmtn.getUserObject();
                File file = fileNode.getFile();
                setSeletedFile(file);
            }
        });
        JScrollPane scrollPane = new JScrollPane(tree);
        scrollPane.setPreferredSize(new Dimension(300, 425)); // JScrollPane 크기 설정
        add(scrollPane);
        
        CreateChildNodes ccn = new CreateChildNodes(rootDirectory, rootNode);
        new Thread(ccn).start();
        
	}

	protected void setSeletedFile(File selectedFile) {
		this.lecturefile = selectedFile;		
	}	

	protected void getTreepath(DefaultMutableTreeNode node) {		
        
    }

	public void initialize() {
		
	}
	
	public Vector<LectureVO> getLecture(File filename) {
		try {
			return cLectureSelection.getLectureInfo(filename);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private void getFileRoot() {
		try {
			this.root = this.cLectureSelection.getLectureRoot();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	public String getSelectedNode() {
		return this.selectednodeName;
	}
	
	public File getSelectedFile() {
		return this.lecturefile;
	}
	
    public class CreateChildNodes implements Runnable {

        private DefaultMutableTreeNode root;
        private File fileRoot;

        public CreateChildNodes(File fileRoot,
                DefaultMutableTreeNode root) {
            this.fileRoot = fileRoot;
            this.root = root;
        }

        public void run() {
            createChildren(fileRoot, root);
        }

        private void createChildren(File fileRoot,
                DefaultMutableTreeNode node) {
            File[] files = fileRoot.listFiles();
            if (files == null) {
                return;
            }

            for (File file : files) {
                DefaultMutableTreeNode childNode  = new DefaultMutableTreeNode(new FileNode(file));
                node.add(childNode);
                if (file.isDirectory()) {
                    createChildren(file, childNode);
                }
            }
        }
    }

    public class FileNode {

        private File file;

        public FileNode(File file) {
            this.file = file;
        }

        /* new */
        public File getFile() {
            return file;
        }

        @Override
        public String toString() {
            String name = file.getName();
            if (name.equals("")) {
                return file.getAbsolutePath();
            } else {
                return name;
            }
        }
    }
}
