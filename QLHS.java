package giaodien_qlhs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class QLHS extends JFrame implements ActionListener , KeyListener{
	//Khai báo biến
	JLabel lb_toan, lb_ly, lb_hoa, lb_diemTB, lb_xepLoai, lb_hBong;
	JTextField tf_toan, tf_ly, tf_hoa, tf_diemTB, tf_xepLoai, tf_hBong;
	JButton btn_tinh, btn_xoa, btn_thoat;
	
	public void giaoDien()
	{
		setLayout(null);
		//cố định kích thước cửa d sổ
		setResizable(false);
		//thoát khi đc nháy chuột vào nút close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300); //kích thước cửa sổ
		setTitle("Quản lý học sinh");//tiêu đề cửa sổ
		
		//tạo lb_toan
		lb_toan = new JLabel("Điểm toán");
		lb_toan.setBounds(5, 10, 100, 25);
		//gắn lb_toan vào cửa sổ
		this.add(lb_toan);
		
		//tạo tf_toan
		tf_toan = new JTextField();
		tf_toan.setBounds(110, 10, 250, 25);
		//gắn tf_toan vào cửa sổ
		this.add(tf_toan);
		
		//tạo lb_ly
		lb_ly = new JLabel("Điểm lý");
		lb_ly.setBounds(5, 40, 100, 25);
		//gắn lb_ly vào cửa sổ
		this.add(lb_ly);
		
		//Tạo tf_ly
		tf_ly = new JTextField();
		tf_ly.setBounds(110,40,250,25);
		//gắn tf_ly vào cửa sổ
		this.add(tf_ly);
		
		//tạo lb_hoa
		lb_hoa = new JLabel("Điểm hóa");
		lb_hoa.setBounds(5, 70, 100, 25);
		this.add(lb_hoa);
		
		//tạo tf_hoa
		tf_hoa = new JTextField();
		tf_hoa.setBounds(110, 70, 250, 25);
		//thêm dòng lệnh để nhấn enter rồi tính, bắt sự kiện nhấn enter
		tf_hoa.addKeyListener(this);
		this.add(tf_hoa);
		
		//tạo lb_diemTB
		lb_diemTB = new JLabel("Điểm TB");
		lb_diemTB.setBounds(5, 100, 100, 25);
		this.add(lb_diemTB);
		
		//tạo tf_diemTB
		tf_diemTB = new JTextField();
		tf_diemTB.setBounds(110, 100, 250, 25);
		//ngăn không cho người dùng nhấn dữ liệu vào ô kết quả
		tf_diemTB.setEditable(false);
		this.add(tf_diemTB);
		
		//tạo lb_xepLoai
		lb_xepLoai = new JLabel("Xếp loại");
		lb_xepLoai.setBounds(5, 130, 100, 25);
		this.add(lb_xepLoai);
		
		//tạo tf_xepLoai
		tf_xepLoai = new JTextField();
		tf_xepLoai.setBounds(110, 130, 250, 25);
		//ngăn không cho người dùng nhấn dữ liệu vào ô kết quả
		tf_xepLoai.setEditable(false);
		this.add(tf_xepLoai);
		
		//tạo lb_hBong
		lb_hBong = new JLabel("Học bổng");
		lb_hBong.setBounds(5, 160, 100, 25);
		this.add(lb_hBong);
		
		//tạo tf_hBong
		tf_hBong = new JTextField();
		tf_hBong.setBounds(110, 160, 250, 25);
		//ngăn không cho người dùng nhấn dữ liệu vào ô kết quả
		tf_hBong.setEditable(false);
		this.add(tf_hBong);
		
		//tạo btn_tinh
		btn_tinh = new JButton("Tính");
		btn_tinh.setBounds(50, 200, 75, 25);
		//thêm dòng lệnh để nhấn enter rồi tính, bắt sự kiện nhấn enter
		btn_tinh.addKeyListener(this);
		//bắt sự kiện nhấn chuột
		btn_tinh.addActionListener(this);
		this.add(btn_tinh);
		
		//tạo btn_xoa
		btn_xoa = new JButton("Xóa");
		btn_xoa.setBounds(160, 200, 75, 25);
		btn_xoa.addActionListener(this);
		this.add(btn_xoa);
		
		//taoj btn_thoat
		btn_thoat = new JButton("Thoát");
		btn_thoat.setBounds(270, 200, 75, 25);
		btn_thoat.addActionListener(this);
		this.add(btn_thoat);
		
		setVisible(true);//hiện cửa sổ
	}
	
	//-----------------------------------
	public static void main(String[] args) {
		new QLHS().giaoDien();
	}
	
	//hàm tính toán
	public void tinhToan()
	{
		int diemToan, diemLy, diemHoa, diemTB, hocBong;
		try
		{
			diemToan = Integer.parseInt(tf_toan.getText()); //lấy giá trị tf_toan gán vào diemToan
			
			diemLy = Integer.parseInt(tf_ly.getText());
			
			diemHoa = Integer.parseInt(tf_hoa.getText());
			
			diemTB = (diemToan + diemLy + diemHoa) / 3;
			
			if(diemTB >= 9 && diemTB <= 10) 
			{
				tf_xepLoai.setText("Giỏi");
				hocBong = 1000000;
			}
			else if(diemTB >= 7 && diemTB <= 9)
			{
				 tf_xepLoai.setText("Khá");
				 hocBong = 700000;
			}
			else if(diemTB >= 5 && diemTB <= 7)
			{
				tf_xepLoai.setText("Trung bình");
				hocBong = 0;
			}
			else 
			{
				tf_xepLoai.setText("Yếu");
				hocBong = 0;
			}
			
			tf_diemTB.setText(diemTB+"");
			tf_hBong.setText(hocBong+"");
			
			
		} catch (Exception e) {
			// hiển thị cửa sổ thông báo lỗi
			JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu - Nhập lại", "Thông báo", JOptionPane.OK_OPTION);
			
		}
	}

	//HÀM BẮT SỰ KIỆN
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn_tinh)
		{
			tinhToan();
		}
		else if(e.getSource() == btn_xoa)
		{
			//nháy chuột vào nút xóa thì 6 ô nhập dữ liệu đều xóa, là truyền chuỗi rỗng vào 6 ô này
			tf_toan.setText("");
			tf_ly.setText(""); 
			tf_hoa.setText("");
			tf_diemTB.setText("");
			tf_xepLoai.setText("");
			tf_hBong.setText("");
			
			//yêu cầu con trỏ về tf_toan để không mất công gõ
			tf_toan.requestFocus();
		}
		else if(e.getSource() == btn_thoat)
		{
			int id;
			id = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "Exit", JOptionPane.OK_CANCEL_OPTION);
			//xem id
			//JOptionPane.showMessageDialog(null, "id nút bấm: "+id, "KT", JOptionPane.OK_OPTION);
			if(id == 0) System.exit(0);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			tinhToan();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
