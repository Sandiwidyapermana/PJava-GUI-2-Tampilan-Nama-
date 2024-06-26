import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JOptionPane;



import java.awt.Color;
import java.awt.Font;


public class App {
  public static void main(String[] args) throws Exception {

    // frame
    JFrame mainWindow = new JFrame();
    mainWindow.setSize(1920, 1080);
    mainWindow.setTitle("Frame Utama");
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setLayout(null);
    mainWindow.setLocationRelativeTo(null);
    
    // Panel
    JPanel sidebar = new JPanel();
    sidebar.setSize(200, 1080);
    sidebar.setBackground( new Color(23, 35, 51) );
    sidebar.setLayout(null);
    
    JPanel header = new JPanel();
    header.setBounds(200, 0, 1920, 70);
    header.setBackground(new Color(71, 120, 197));
    header.setLayout(null);

    JPanel content = new JPanel();
    content.setBounds(200, 70, 1920, 1080);
    content.setBackground(Color.WHITE);
    content.setLayout(null);

    // ini component
    JLabel title = new JLabel("Data User");
    title.setBounds(20, 20, 300, 30);
    title.setFont(new Font("Poppins Bold", Font.PLAIN, 30));

    String[] dataUserHeader = {"Nama", "Username", "Umur"};
    String[][] dataUser = {
      {"Sandi Widya Permana", "Sandi", "21"},
      {"Ananda Cahyo K.", "Nanda", "20"},
      {"Dini Ika Kurnia", "Dini", "20"},
      {"Annisa Kusuma Dewi", "Annisa", "19"},
    };

    DefaultTableModel dmUser = new DefaultTableModel(dataUser, dataUserHeader);

    JTable tblUser = new JTable(dmUser){
      @Override
      public boolean isCellEditable(int row, int column){
        return false;
      }
    };
    tblUser.setFont( new Font("Poppins", Font.PLAIN, 16) );
    tblUser.getTableHeader().setFont( new Font("Poppins Medium", Font.PLAIN, 20) );
    tblUser.getTableHeader().setBackground( new Color(71, 120, 197) );
    tblUser.getTableHeader().setForeground( Color.WHITE );
    tblUser.setRowHeight(25);
    tblUser.getTableHeader().setReorderingAllowed(false);
    
    tblUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tblUser.setDragEnabled(true);

    dmUser.addRow( new String[]{"Vegananda Layliya", "Vega", "20"} );

    JScrollPane scrollTblUser = new JScrollPane(tblUser);
    scrollTblUser.setBounds(20, (int)title.getLocation().getY()+45, 600, 300);
    scrollTblUser.getViewport().setBackground(Color.WHITE);

    // event handling
    tblUser.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mousePressed(java.awt.event.MouseEvent me){
        int selectedIndex = tblUser.getSelectedRow();
        String nama = tblUser.getValueAt(selectedIndex, 0).toString();
        String username = tblUser.getValueAt(selectedIndex, 1).toString();
        String umur = tblUser.getValueAt(selectedIndex, 2).toString();

        String message = 
          "Nama : " + nama + "\n"
          + "Username : " + username + "\n"
          + "Umur : " + umur + "\n"
        ;

        JOptionPane.showMessageDialog(mainWindow, message, "Hasil Seleksi", JOptionPane.INFORMATION_MESSAGE);

      }

    } );


    
    // finally
    content.add(title);
    content.add(scrollTblUser);
    mainWindow.add(sidebar);
    mainWindow.add(header);
    mainWindow.add(content);
    mainWindow.setVisible(true);

  }
}
