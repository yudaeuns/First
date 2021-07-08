

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



class Result extends JDialog {
	public Result() {
		setModal(true);
		Random round = new Random();
		JPanel resultpnl = new JPanel();
		JPanel resultpnl2 = new JPanel();
		JLabel resultlbl = new JLabel((round.nextInt(999) + 1) + "회차 로또 추첨결과!!");

		JLabel resultnum = new JLabel();
		ArrayList<Integer> number = new ArrayList<Integer>();
		for (int i = 0; i < 45; i++) {
			number.add(i);
		}

		Collections.shuffle(number);
		int[] num = new int[6];
		for (int i = 0; i < 6; i++) {
			num[i] = number.get(i);
		}

		JPanel selectpnl = new JPanel();
		JLabel selectNum = new JLabel("숫자확인");
		
		
		selectpnl.add(selectNum);
		
//		selectNum.setSize(gets);
//		selectNum.setText();
		
//		selectNum.setText(Arrays.toString(picked1));
		resultlbl.setFont(new Font("굴림체", Font.BOLD, 19));
//		resultlbl.setForeground(Color.blue);
		resultnum.setText("당첨번호 " + Arrays.toString(num));
		resultnum.setFont(new Font("굴림체", Font.BOLD, 20));
		resultnum.setForeground(Color.red);

		resultpnl.add(resultlbl);
		resultpnl2.add(resultnum);

		add(resultpnl, "North");
		add(resultpnl2, "Center");
		add(selectpnl, "South");

		setSize(500, 400);

	}
}

public class Main extends JFrame {
	final int MAX_SELECTED = 6;
	int selectionCounter = 0;
	public ArrayList<Integer> numbers1 = new ArrayList<Integer>();
	public int[] picked1 = new int[6];

	public Main() {
//		JFrame frame = new JFrame("LOTTO");		// 타이틀 & 아이콘
//		ImageIcon img = new ImageIcon("image/logo_bak.gif");
//		frame.setIconImage(img.getImage());
//		frame.setVisible(true);

		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(5, 3));
		JLabel number = new JLabel("Number A");
		JButton again = new JButton("번호 수정");
		JButton retry = new JButton("자동 번호 생성");
		JButton delete = new JButton("번호 삭제");
		number.setVisible(false);
		again.setVisible(false);
		retry.setVisible(false);
		delete.setVisible(false);

		JLabel number2 = new JLabel("Number B");
		JButton again2 = new JButton("번호 수정");
		JButton retry2 = new JButton("자동 번호 생성");
		JButton delete2 = new JButton("번호 삭제");
		number2.setVisible(false);
		again2.setVisible(false);
		retry2.setVisible(false);
		delete2.setVisible(false);

		JLabel number3 = new JLabel("Number C");
		JButton again3 = new JButton("번호 수정");
		JButton retry3 = new JButton("자동 번호 생성");
		JButton delete3 = new JButton("번호 삭제");
		number3.setVisible(false);
		again3.setVisible(false);
		retry3.setVisible(false);
		delete3.setVisible(false);

		JLabel number4 = new JLabel("Number D");
		JButton again4 = new JButton("번호 수정");
		JButton retry4 = new JButton("자동 번호 생성");
		JButton delete4 = new JButton("번호 삭제");
		number4.setVisible(false);
		again4.setVisible(false);
		retry4.setVisible(false);
		delete4.setVisible(false);

		JLabel number5 = new JLabel("Number E");
		JButton again5 = new JButton("번호 수정");
		JButton retry5 = new JButton("자동 번호 생성");
		JButton delete5 = new JButton("번호 삭제");
		number5.setVisible(false);
		again5.setVisible(false);
		retry5.setVisible(false);
		delete5.setVisible(false);

		JPanel pnl2 = new JPanel();
		JButton check = new JButton("Number A 선택");
		JButton check2 = new JButton("Number B 선택");
		JButton check3 = new JButton("Number C 선택");
		JButton check4 = new JButton("Number D 선택");
		JButton check5 = new JButton("Number E 선택");
		JButton okay = new JButton("OK");
		check.setVisible(false);
		check2.setVisible(false);
		check3.setVisible(false);
		check4.setVisible(false);
		check5.setVisible(false);

		JPanel pnl3 = new JPanel();
		JLabel times = new JLabel("횟수를 선택하세요");
		Integer[] num = { 1, 2, 3, 4, 5 };
		JComboBox<Integer> combo = new JComboBox<Integer>(num);

		JPanel pnl4 = new JPanel();
		pnl4.setLayout(new GridLayout(9, 5));
		JCheckBox[] cnt = new JCheckBox[45];
		int[] cnts = new int[45];
		for (int i = 0; i < 45; i++) {
			cnts[i] = i + 1;
			cnt[i] = new JCheckBox(String.valueOf(cnts[i]));
			cnt[i].addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					JCheckBox source = (JCheckBox) e.getSource();
					int num = Integer.parseInt(source.getText());

					if (source.isSelected()) {
						selectionCounter++;
						if (selectionCounter > 6) {
							JOptionPane.showMessageDialog(pnl, "선택 수량이 초과하였습니다", "ERROR_MESSAGE",
									JOptionPane.ERROR_MESSAGE);

						}
					} else {
						selectionCounter--;
					}

				}
			});

		}

		JPanel pnl5 = new JPanel();
		pnl5.setLayout(new GridLayout(3, 0));
		JLabel nothing = new JLabel("     ");
		JLabel nothing1 = new JLabel("     ");
		JLabel nothing2 = new JLabel("     ");

		pnl.add(number);
		pnl.add(again);
		again.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				for (int i = 0; i < cnts.length; i++) {
//
//					cnt[i].setSelected(false);
//				}
				check.setVisible(true);
			}
		});

		ArrayList<Integer> retryNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= 45; i++) {
			retryNumbers.add(i);
		}
		pnl.add(retry);
		retry.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < cnts.length; i++) {

					cnt[i].setSelected(false);
				}
//				TreeSet<Integer> chkNum1 = new TreeSet<Integer>();
//				int selSize = 0;
//				for (int i = 0; i < 45; i++) {
//					if (cnt[i].isSelected()) {
//						chkNum1.add(Integer.parseInt(cnt[i].getText()));
//						selSize++;
//					}
//
//					cnt[i].setSelected(false);
//				}
//				Collections.shuffle(retryNumbers);
//				for (int i = 0; i < 10; i++) {
//					if (chkNum1.size() < 6)
//						chkNum1.add(retryNumbers.get(i));
//				}
//				number.setText(chkNum1.toString());

//				ArrayList<Integer> numbers1 = new ArrayList<Integer>();
				for (int i = 1; i <= 45; i++) {
					numbers1.add(i);
				}
				Collections.shuffle(numbers1);
//				int[] picked1 = new int[6];
				int[] picked11 = new int[6];
				for (int i = 0; i < 6; i++) {
					picked1[i] = numbers1.get(i);
					System.out.println(numbers1.get(i));
					picked11[i] = numbers1.get(i);
				}

//		        for (int num : numbers1) {
//		            System.out.print(num + "\n");
//		        }
				System.out.println();
				number.setText(Arrays.toString(picked1));
				check.setVisible(false);
			}

		});

		pnl.add(delete);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < cnts.length; i++) {

					cnt[i].setSelected(false);
				}
				number.setText("Number A");
				check.setVisible(true);
			}
		});

		pnl.add(number2);
		pnl.add(again2);
		again2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				check2.setVisible(true);
			}
		});
		pnl.add(retry2);
		retry2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < cnts.length; i++) {

					cnt[i].setSelected(false);
				}
				ArrayList<Integer> numbers1 = new ArrayList<Integer>();
				for (int i = 1; i <= 45; i++) {
					numbers1.add(i);
				}
				Collections.shuffle(numbers1);
				int[] picked1 = new int[6];
				for (int i = 0; i < 6; i++) {
					picked1[i] = numbers1.get(i);
				}
				number2.setText(Arrays.toString(picked1));
				check2.setVisible(false);
			}
		});
		pnl.add(delete2);
		delete2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < cnts.length; i++) {

					cnt[i].setSelected(false);
				}
				number2.setText("Number B");
				check2.setVisible(true);
			}
		});

		pnl.add(number3);
		pnl.add(again3);
		again3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				check3.setVisible(true);
			}
		});
		pnl.add(retry3);
		retry3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < cnts.length; i++) {

					cnt[i].setSelected(false);
				}
				ArrayList<Integer> numbers1 = new ArrayList<Integer>();
				for (int i = 1; i <= 45; i++) {
					numbers1.add(i);
				}
				Collections.shuffle(numbers1);
				int[] picked1 = new int[6];
				for (int i = 0; i < 6; i++) {
					picked1[i] = numbers1.get(i);
				}
				number3.setText(Arrays.toString(picked1));
				check3.setVisible(false);
			}
		});
		pnl.add(delete3);
		delete3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < cnts.length; i++) {

					cnt[i].setSelected(false);
				}
				number3.setText("Number C");
				check3.setVisible(true);
			}
		});

		pnl.add(number4);
		pnl.add(again4);
		again4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				check4.setVisible(true);
			}
		});
		pnl.add(retry4);
		retry4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < cnts.length; i++) {

					cnt[i].setSelected(false);
				}
				ArrayList<Integer> numbers1 = new ArrayList<Integer>();
				for (int i = 1; i <= 45; i++) {
					numbers1.add(i);
				}
				Collections.shuffle(numbers1);
				int[] picked1 = new int[6];
				for (int i = 0; i < 6; i++) {
					picked1[i] = numbers1.get(i);
				}
				number4.setText(Arrays.toString(picked1));
				check4.setVisible(false);
			}
		});
		pnl.add(delete4);
		delete4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < cnts.length; i++) {

					cnt[i].setSelected(false);
				}
				number4.setText("Number D");
				check4.setVisible(true);
			}
		});

		pnl.add(number5);
		pnl.add(again5);
		again5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				check5.setVisible(true);
			}
		});
		pnl.add(retry5);
		retry5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < cnts.length; i++) {

					cnt[i].setSelected(false);
				}
				ArrayList<Integer> numbers1 = new ArrayList<Integer>();
				for (int i = 1; i <= 45; i++) {
					numbers1.add(i);
				}
				Collections.shuffle(numbers1);
				int[] picked1 = new int[6];
				for (int i = 0; i < 6; i++) {
					picked1[i] = numbers1.get(i);
				}
				number5.setText(Arrays.toString(picked1));
				check5.setVisible(false);
			}
		});
		pnl.add(delete5);
		delete5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < cnts.length; i++) {

					cnt[i].setSelected(false);
				}
				number5.setText("Number E");
				check5.setVisible(true);
			}
		});

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 45; i++) {
			numbers.add(i);
		}
		pnl2.add(check);
		check.addActionListener(new ActionListener() { //
			@Override
			public void actionPerformed(ActionEvent e) {
				TreeSet<Integer> chkNum1 = new TreeSet<Integer>();
				int selSize = 0;
				for (int i = 0; i < 45; i++) {
					if (cnt[i].isSelected()) {
						chkNum1.add(Integer.parseInt(cnt[i].getText()));
						selSize++;
					}

					cnt[i].setSelected(false);
				}
				Collections.shuffle(numbers);
				for (int i = 0; i < 10; i++) {
					if (chkNum1.size() < 6)
						chkNum1.add(numbers.get(i));
				}
				number.setText(chkNum1.toString());

				check.setVisible(false);
			}
		});
		pnl2.add(check2);
		check2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TreeSet<Integer> chkNum1 = new TreeSet<Integer>();
				int selSize = 0;
				for (int i = 0; i < 45; i++) {
					if (cnt[i].isSelected()) {
						chkNum1.add(Integer.parseInt(cnt[i].getText()));
						selSize++;
					}
					cnt[i].setSelected(false);
				}
				Collections.shuffle(numbers);
				for (int i = 0; i < 10; i++) {
					if (chkNum1.size() < 6)
						chkNum1.add(numbers.get(i));
				}
				number2.setText(chkNum1.toString());

				check2.setVisible(false);
			}
		});
		pnl2.add(check3);
		check3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TreeSet<Integer> chkNum1 = new TreeSet<Integer>();
				int selSize = 0;
				for (int i = 0; i < 45; i++) {
					if (cnt[i].isSelected()) {
						chkNum1.add(Integer.parseInt(cnt[i].getText()));
						selSize++;
					}
					cnt[i].setSelected(false);
				}
				Collections.shuffle(numbers);
				for (int i = 0; i < 10; i++) {
					if (chkNum1.size() < 6)
						chkNum1.add(numbers.get(i));
				}
				number3.setText(chkNum1.toString());

				check3.setVisible(false);
			}
		});
//		pnl2.add(okay);
//		okay.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JDialog ResultLotto = new Result();
//				ResultLotto.setVisible(true);
//			}
//		});
		pnl2.add(check4);
		check4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TreeSet<Integer> chkNum1 = new TreeSet<Integer>();
				int selSize = 0;
				for (int i = 0; i < 45; i++) {
					if (cnt[i].isSelected()) {
						chkNum1.add(Integer.parseInt(cnt[i].getText()));
						selSize++;
					}
					cnt[i].setSelected(false);
				}
				Collections.shuffle(numbers);
				for (int i = 0; i < 10; i++) {
					if (chkNum1.size() < 6)
						chkNum1.add(numbers.get(i));
				}
				number4.setText(chkNum1.toString());

				check4.setVisible(false);
			}
		});
		pnl2.add(check5);
		check5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TreeSet<Integer> chkNum1 = new TreeSet<Integer>();
				int selSize = 0;
				for (int i = 0; i < 45; i++) {
					if (cnt[i].isSelected()) {
						chkNum1.add(Integer.parseInt(cnt[i].getText()));
						selSize++;
					}
					cnt[i].setSelected(false);
				}
				Collections.shuffle(numbers);
				for (int i = 0; i < 10; i++) {
					if (chkNum1.size() < 6)
						chkNum1.add(numbers.get(i));
				}
				number5.setText(chkNum1.toString());

				check5.setVisible(false);
			}
		});
		pnl2.add(okay);
		okay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog ResultLotto = new Result();
				ResultLotto.setVisible(true);
//				Result.round2++;
			}
		});

		pnl3.add(times);
		pnl3.add(combo);
		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				JComboBox<Integer> c = (JComboBox<Integer>) source;
				int index = c.getSelectedIndex();

				if (index == 0) {
					number.setVisible(true);
					number2.setVisible(false);
					number3.setVisible(false);
					number4.setVisible(false);
					number5.setVisible(false);
					again.setVisible(true);
					again2.setVisible(false);
					again3.setVisible(false);
					again4.setVisible(false);
					again5.setVisible(false);
					retry.setVisible(true);
					retry2.setVisible(false);
					retry3.setVisible(false);
					retry4.setVisible(false);
					retry5.setVisible(false);
					delete.setVisible(true);
					delete2.setVisible(false);
					delete3.setVisible(false);
					delete4.setVisible(false);
					delete5.setVisible(false);
					check.setVisible(true);
					check2.setVisible(false);
					check3.setVisible(false);
					check4.setVisible(false);
					check5.setVisible(false);
				} else if (index == 1) {
					number.setVisible(true);
					number2.setVisible(true);
					number3.setVisible(false);
					number4.setVisible(false);
					number5.setVisible(false);
					again.setVisible(true);
					again2.setVisible(true);
					again3.setVisible(false);
					again4.setVisible(false);
					again5.setVisible(false);
					retry.setVisible(true);
					retry2.setVisible(true);
					retry3.setVisible(false);
					retry4.setVisible(false);
					retry5.setVisible(false);
					delete.setVisible(true);
					delete2.setVisible(true);
					delete3.setVisible(false);
					delete4.setVisible(false);
					delete5.setVisible(false);
					check.setVisible(true);
					check2.setVisible(true);
					check3.setVisible(false);
					check4.setVisible(false);
					check5.setVisible(false);
				} else if (index == 2) {
					number.setVisible(true);
					number2.setVisible(true);
					number3.setVisible(true);
					number4.setVisible(false);
					number5.setVisible(false);
					again.setVisible(true);
					again2.setVisible(true);
					again3.setVisible(true);
					again4.setVisible(false);
					again5.setVisible(false);
					retry.setVisible(true);
					retry2.setVisible(true);
					retry3.setVisible(true);
					retry4.setVisible(false);
					retry5.setVisible(false);
					delete.setVisible(true);
					delete2.setVisible(true);
					delete3.setVisible(true);
					delete4.setVisible(false);
					delete5.setVisible(false);
					check.setVisible(true);
					check2.setVisible(true);
					check3.setVisible(true);
					check4.setVisible(false);
					check5.setVisible(false);
				} else if (index == 3) {
					number.setVisible(true);
					number2.setVisible(true);
					number3.setVisible(true);
					number4.setVisible(true);
					number5.setVisible(false);
					again.setVisible(true);
					again2.setVisible(true);
					again3.setVisible(true);
					again4.setVisible(true);
					again5.setVisible(false);
					retry.setVisible(true);
					retry2.setVisible(true);
					retry3.setVisible(true);
					retry4.setVisible(true);
					retry5.setVisible(false);
					delete.setVisible(true);
					delete2.setVisible(true);
					delete3.setVisible(true);
					delete4.setVisible(true);
					delete5.setVisible(false);
					check.setVisible(true);
					check2.setVisible(true);
					check3.setVisible(true);
					check4.setVisible(true);
					check5.setVisible(false);
				} else if (index == 4) {
					number.setVisible(true);
					number2.setVisible(true);
					number3.setVisible(true);
					number4.setVisible(true);
					number5.setVisible(true);
					again.setVisible(true);
					again2.setVisible(true);
					again3.setVisible(true);
					again4.setVisible(true);
					again5.setVisible(true);
					retry.setVisible(true);
					retry2.setVisible(true);
					retry3.setVisible(true);
					retry4.setVisible(true);
					retry5.setVisible(true);
					delete.setVisible(true);
					delete2.setVisible(true);
					delete3.setVisible(true);
					delete4.setVisible(true);
					delete5.setVisible(true);
					check.setVisible(true);
					check2.setVisible(true);
					check3.setVisible(true);
					check4.setVisible(true);
					check5.setVisible(true);
				}
			}
		});

		for (int i = 0; i < cnt.length; i++) {
			pnl4.add(cnt[i]);
		}

		pnl5.add(nothing);
		pnl5.add(nothing1);
		pnl5.add(nothing2);

		add(pnl, "East");
		add(pnl2, "South");
		add(pnl3, "North");
		add(pnl4, "West");
		add(pnl5, "Center");

		showGUI();
	}

	private void showGUI() {

		setSize(800, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {

		new Main();
	}

}