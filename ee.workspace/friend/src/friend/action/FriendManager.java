package friend.action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import friend.bean.FriendDTO;
import friend.dao.FriendDAO;

@SuppressWarnings("serial")
public class FriendManager extends JFrame implements ActionListener, ListSelectionListener {
	private JLabel insertL, nameL, callL, barL, barL2, genderL, hobbyL, listL, analyseL;
	private JTextField nameT, midlePhoneT, lastPhoneT;
	private JRadioButton maleB, femaleB;
	private JCheckBox readB, movieB, musicB, gameB, shoppingB;
	private JButton insertB, updateB, deleteB, removeB;
	private JComboBox<String> frontC;
	private JPanel insertP, iP1, iP2, iP3, iP4, iP5, listP, analyseP;
	private JTextArea analyse;
	private ButtonGroup g;
	private JList<FriendDTO> list;
	private DefaultListModel<FriendDTO> model;

	public FriendManager() {
		insertL = new JLabel("개인정보입력");
		insertL.setHorizontalAlignment(JLabel.CENTER);

		nameL = new JLabel("이         름:");
		nameT = new JTextField(10);

		callL = new JLabel("전화번호:");
		barL = new JLabel("-");
		barL2 = new JLabel("-");
		String frontNumber[] = { "010", "011", "017", "019" };
		frontC = new JComboBox<String>(frontNumber);
		midlePhoneT = new JTextField(5);
		lastPhoneT = new JTextField(5);

		genderL = new JLabel("성         별:");
		maleB = new JRadioButton("남성");
		maleB.setSelected(true);
		femaleB = new JRadioButton("여성");
		g = new ButtonGroup();
		g.add(maleB);
		g.add(femaleB);

		hobbyL = new JLabel("취         미:");
		readB = new JCheckBox("독서");
		movieB = new JCheckBox("영화");
		musicB = new JCheckBox("음악");
		gameB = new JCheckBox("게임");
		shoppingB = new JCheckBox("쇼핑");

		insertB = new JButton("등록");
		updateB = new JButton("수정");
		updateB.setEnabled(false);
		deleteB = new JButton("삭제");
		deleteB.setEnabled(false);
		removeB = new JButton("지우기");
		removeB.setEnabled(false);

		iP1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		iP1.add(nameL);
		iP1.add(nameT);

		iP2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		iP2.add(callL);
		iP2.add(frontC);
		iP2.add(barL);
		iP2.add(midlePhoneT);
		iP2.add(barL2);
		iP2.add(lastPhoneT);

		iP3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		iP3.add(genderL);
		iP3.add(maleB);
		iP3.add(femaleB);

		iP4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		iP4.add(hobbyL);
		iP4.add(readB);
		iP4.add(movieB);
		iP4.add(musicB);
		iP4.add(gameB);
		iP4.add(shoppingB);

		iP5 = new JPanel(new FlowLayout());
		iP5.add(insertB);
		iP5.add(updateB);
		iP5.add(deleteB);
		iP5.add(removeB);

		insertP = new JPanel(new GridLayout(6, 1));
		insertP.add(insertL);
		insertP.add(iP1);
		insertP.add(iP2);
		insertP.add(iP3);
		insertP.add(iP4);
		insertP.add(iP5);
		insertP.setBounds(10, 10, 360, 250);

		//
		listL = new JLabel("전체목록");
		listL.setHorizontalAlignment(JLabel.CENTER);

		list = new JList<FriendDTO>(new DefaultListModel<FriendDTO>());
		model = (DefaultListModel<FriendDTO>) list.getModel();
		JScrollPane scroll = new JScrollPane(list);

		listP = new JPanel(new BorderLayout());
		listP.add("North", listL);
		listP.add(scroll);
		listP.setBounds(370, 10, 100, 250);

		//
		analyseL = new JLabel("개인정보분석");
		analyseL.setHorizontalAlignment(JLabel.CENTER);
		analyse = new JTextArea(10, 60);

		analyseP = new JPanel();
		analyseP.add("North", analyseL);
		analyseP.add(analyse);
		analyseP.setBounds(20, 260, 450, 100);

		// color
		iP1.setBackground(new Color(21, 160, 121));
		iP2.setBackground(new Color(21, 160, 121));
		maleB.setBackground(new Color(21, 160, 121));
		femaleB.setBackground(new Color(21, 160, 121));
		iP3.setBackground(new Color(21, 160, 121));
		readB.setBackground(new Color(21, 160, 121));
		movieB.setBackground(new Color(21, 160, 121));
		musicB.setBackground(new Color(21, 160, 121));
		gameB.setBackground(new Color(21, 160, 121));
		shoppingB.setBackground(new Color(21, 160, 121));
		iP4.setBackground(new Color(21, 160, 121));
		iP5.setBackground(new Color(21, 160, 121));
		insertP.setBackground(new Color(21, 160, 121));
		listP.setBackground(new Color(21, 160, 121));
		analyseP.setBackground(new Color(21, 160, 121));

		//
		Container c = getContentPane();
		c.setLayout(null);
		c.add(insertP);
		c.add(listP);
		c.add(analyseP);
		c.setBackground(new Color(21, 160, 121));

		setBounds(200, 300, 500, 420);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// db에있는 모든 레코드를 꺼내서 jlist에 뿌리기
		FriendDAO friendDAO = FriendDAO.getInstance();
		List<FriendDTO> list2 = friendDAO.getFriendList();

		for (FriendDTO dto : list2) {
			model.addElement(dto);
		}
	}

	public void event() {
		insertB.addActionListener(this);
		list.addListSelectionListener(this);
		updateB.addActionListener(this);
		deleteB.addActionListener(this);
		removeB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insertB) {
			// 데이터
			String name = nameT.getText();
			String tel1 = frontC.getSelectedItem().toString();
			String tel2 = midlePhoneT.getText();
			String tel3 = lastPhoneT.getText();
			int gender = maleB.isSelected() ? 0 : 1;
			int read = readB.isSelected() ? 1 : 0;
			int movie = movieB.isSelected() ? 1 : 0;
			int music = musicB.isSelected() ? 1 : 0;
			int game = gameB.isSelected() ? 1 : 0;
			int shopping = shoppingB.isSelected() ? 1 : 0;

			// FriendDTO -1인분
			FriendDTO friendDTO = new FriendDTO();
			friendDTO.setName(name);
			friendDTO.setTel1(tel1);
			friendDTO.setTel2(tel2);
			friendDTO.setTel3(tel3);
			friendDTO.setGender(gender);
			friendDTO.setRead(read);
			friendDTO.setMovie(movie);
			friendDTO.setMusic(music);
			friendDTO.setGame(game);
			friendDTO.setShopping(shopping);

			// FriendDAO -- db
			FriendDAO friendDAO = FriendDAO.getInstance();// 싱글톤

			int seq = friendDAO.getSeq();
			friendDTO.setSeq(seq);

			friendDAO.friendInsert(friendDTO);

			// 결과
			clear();

			analyse.setText("\n\t\t\t 데이터를 등록하였습니다.");
			model.addElement(friendDTO);

		} else if (e.getSource() == updateB) {
			String name = list.getSelectedValue().toString();

			FriendDAO friendDAO = FriendDAO.getInstance();
			List<FriendDTO> list2 = friendDAO.getFriendList();

			// 데이터
			String newname = nameT.getText();
			String tel1 = frontC.getSelectedItem().toString();
			String tel2 = midlePhoneT.getText();
			String tel3 = lastPhoneT.getText();
			int gender = maleB.isSelected() ? 0 : 1;
			int read = readB.isSelected() ? 1 : 0;
			int movie = movieB.isSelected() ? 1 : 0;
			int music = musicB.isSelected() ? 1 : 0;
			int game = gameB.isSelected() ? 1 : 0;
			int shopping = shoppingB.isSelected() ? 1 : 0;

			for (FriendDTO friendDTO : list2) {
				if (friendDTO.getName().equals(name)) {
					friendDTO.setName(newname);
					friendDTO.setTel1(tel1);
					friendDTO.setTel2(tel2);
					friendDTO.setTel3(tel3);
					friendDTO.setGender(gender);
					friendDTO.setRead(read);
					friendDTO.setMovie(movie);
					friendDTO.setMusic(music);
					friendDTO.setGame(game);
					friendDTO.setShopping(shopping);
					friendDAO.friendUpdate(friendDTO);

					analyse.setText("\n\t\t\t 데이터를 수정하였습니다.");
					model.set(list.getSelectedIndex(), friendDTO);
				}
			}

		} else if (e.getSource() == deleteB) {
			String name = list.getSelectedValue().toString();

			FriendDAO friendDAO = FriendDAO.getInstance();
			List<FriendDTO> list2 = friendDAO.getFriendList();

			for (FriendDTO friendDTO : list2) {
				if (friendDTO.getName().equals(name)) {
					friendDAO.friendDelete(friendDTO);
					list2.remove(friendDTO);
					model.remove(list.getSelectedIndex());
					list.setSelectedIndex(0);
					analyse.setText("\n\t\t\t 데이터를 삭제하였습니다.");
					break;
				}
			}
		} else if (e.getSource() == removeB) {
			insertB.setEnabled(true);
			updateB.setEnabled(false);
			deleteB.setEnabled(false);
			removeB.setEnabled(false);
			clear();
		}
	}

	private void clear() {
		nameT.setText("");
		frontC.setSelectedIndex(0);
		midlePhoneT.setText("");
		lastPhoneT.setText("");
		maleB.setSelected(true);
		readB.setSelected(false);
		movieB.setSelected(false);
		musicB.setSelected(false);
		gameB.setSelected(false);
		shoppingB.setSelected(false);
		analyse.setText("");
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		updateB.setEnabled(true);
		deleteB.setEnabled(true);
		removeB.setEnabled(true);
		insertB.setEnabled(false);
		updateList();
	}

	public void updateList() {
		clear();
		if (list.getSelectedValue() == null)
			return;
		String name = list.getSelectedValue().toString();

		FriendDAO friendDAO = FriendDAO.getInstance();
		List<FriendDTO> list2 = friendDAO.getFriendList();

		for (FriendDTO dto : list2) {
			if (dto.getName().equals(name)) {
				nameT.setText(dto.getName());
				frontC.setSelectedItem(dto.getTel1());
				midlePhoneT.setText(dto.getTel2());
				lastPhoneT.setText(dto.getTel3());
				if (dto.getGender() == 0) {
					maleB.setSelected(true);
				} else {
					femaleB.setSelected(true);
				}
				if (dto.getRead() == 1)
					readB.setSelected(true);
				if (dto.getMovie() == 1)
					movieB.setSelected(true);
				if (dto.getMusic() == 1)
					musicB.setSelected(true);
				if (dto.getGame() == 1)
					gameB.setSelected(true);
				if (dto.getShopping() == 1)
					shoppingB.setSelected(true);
			}
		}
	}

	public static void main(String[] args) {
		new FriendManager().event();
	}
}
