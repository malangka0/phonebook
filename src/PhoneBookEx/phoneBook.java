package PhoneBookEx;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class phoneBook extends JFrame{
	
	Container contentPane = getContentPane();
	JButton jb1, jb2, jb3, jb4, jb5;
	JTextField jf1, jf2, jf3;
	JTextArea jta;
	JLabel jl1, jl2, jl3;
	
	HashMap<String, Person> map = new HashMap<String, Person>();
	
	
	public phoneBook() {
		setTitle("��ȭ��ȣ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		contentPane.setBackground(Color.GRAY);
		contentPane.setLayout(null);
		
		JPanel jp1 = new JPanel();					// ��� �޴�â
		jp1.setLayout(new GridLayout(1,5));
		jp1.setSize(440, 40);
		jp1.setLocation(40, 50);
		
		jb1 = new JButton("�߰�");
		jb2 = new JButton("����");
		jb3 = new JButton("�˻�");
		jb4 = new JButton("��ȸ");
		jb5 = new JButton("����");
		
		jb1.setBackground(Color.YELLOW);
		jb2.setBackground(Color.YELLOW);
		jb3.setBackground(Color.YELLOW);
		jb4.setBackground(Color.YELLOW);
		jb5.setBackground(Color.YELLOW);
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		jp1.add(jb5);
		
		JPanel jp2 = new JPanel();					// �Է�â
		jp2.setLayout(new GridLayout(3,1,5,5));
		jp2.setSize(320, 200);
		jp2.setLocation(160, 120);
		jp2.setBackground(Color.lightGray);
		
		jf1 = new JTextField();
		jf2 = new JTextField();
		jf3 = new JTextField();
		
		jp2.add(jf1);
		jp2.add(jf2);
		jp2.add(jf3);
	
		JPanel jp3 = new JPanel();					// ���� ���â
		jp3.setLayout(new GridLayout(3,1,5,5));
		jp3.setSize(100,200);
		jp3.setLocation(40, 120);
		jp2.setBackground(Color.lightGray);
		
		jl1 = new JLabel("�̸�");
		jl2 = new JLabel("��ȣ");
		jl3 = new JLabel("�ּ�");

		jp3.add(jl1);
		jp3.add(jl2);
		jp3.add(jl3);
		
		
		jta = new JTextArea();
		JScrollPane js = new JScrollPane(jta);
		js.setSize(320, 320);
		js.setLocation(520, 40);
		add(js);
		
		add(jp1);
		add(jp2);
		add(jp3);
		setSize(900, 430);
		setVisible(true);
		
		Add listenerA = new Add();
		Del listenerB = new Del();
		Sch listenerC = new Sch();
		Vew listenerD = new Vew();
		Ext listenerE = new Ext();
				
		jb1.addActionListener(listenerA);
		jb2.addActionListener(listenerB);
		jb3.addActionListener(listenerC);
		jb4.addActionListener(listenerD);
		jb5.addActionListener(listenerE);
	
		
	}
	
	// �߰�
	class Add implements ActionListener{
		public void actionPerformed(ActionEvent E) {
			map.put(jf1.getText(),new Person(jf1.getText(), jf2.getText(), jf3.getText()));
			if (jf1.getText().equals("")) {
				jta.append("�ٽ� �Է��Ͻÿ�");
			} else {
				jta.setText("");
				jta.append(jf1.getText() + " ��� �Ϸ�\n");
			}
			
			jf1.setText("");
			jf2.setText("");
			jf3.setText("");
			
		}
	}
	
	// ����
	class Del implements ActionListener{
		public void actionPerformed(ActionEvent E) {
			String deletePerson = jf1.getText();
			
			if(map.containsKey(deletePerson)) {
				map.remove(deletePerson);
				jta.setText("");
				jta.append(jf1.getText() + " ���� �Ϸ�\n");
			} else {
				jta.setText("");
				jta.append(jf1.getText() + "��ϵ� ���� ����\n");
			}
			jf1.setText("");
			jf2.setText("");
			jf3.setText("");
		}
	}

	// �˻�
	class Sch implements ActionListener{
		public void actionPerformed(ActionEvent E) {
			String searchPerson = jf1.getText();
			
			if(map.containsKey(searchPerson)) {
				Person contact = map.get(searchPerson);
				jta.append( "<" + contact.name + ">\n" + "��ȣ : "+ contact.number + "\n" + "�ּ� : " + contact.address + "\n");
			}
			else {
				jta.setText("");
				jta.append(jf1.getText() + "��ϵ� ���� ����\n");
			}
			jf1.setText("");
			jf2.setText("");
			jf3.setText("");
		}
	}
	
	
	// ��ȸ
	class Vew implements ActionListener{
		public void actionPerformed(ActionEvent E) {
			jta.setText("");
			Vector<String> v = new Vector<String>();
			Set<String> names = map.keySet();
			v.addAll(names);
			Collections.sort(v);
			Iterator<String> it = v.iterator();
			
			while (it.hasNext()) {
				String name = it.next();
				Person contact = map.get(name);
				jta.append("<" + contact.name + ">\n" + "��ȣ : "+ contact.number + "\n" + "�ּ� : " + contact.address + "\n");
			}
			
			jf1.setText("");
			jf2.setText("");
			jf3.setText("");
		}
	}
	
	// ����
	class Ext implements ActionListener{
		public void actionPerformed(ActionEvent E) {
			System.exit(0);
		}
	}

		public static void main (String[] args) {
			new phoneBook();
		}
}

