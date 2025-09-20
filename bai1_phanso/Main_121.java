package bai1_phanso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main_121 extends JFrame {
    private JTextField tu1Field, mau1Field, tu2Field, mau2Field;
    private JLabel ketQuaLabel;

    public Main_121() {
        setTitle("Ung dung Quan ly Phan So - Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Noi dung chinh
        JPanel content = new JPanel();
        content.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Tinh toan voi phan so");
        title.setFont(new Font("SansSerif", Font.BOLD, 16));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(title);
        content.add(Box.createRigidArea(new Dimension(0,10)));

        JPanel inputPanel = new JPanel(new GridLayout(2,4,8,8));
        inputPanel.add(new JLabel("Tu so 1:"));
        tu1Field = new JTextField();
        inputPanel.add(tu1Field);
        inputPanel.add(new JLabel("Mau so 1:"));
        mau1Field = new JTextField();
        inputPanel.add(mau1Field);

        inputPanel.add(new JLabel("Tu so 2:"));
        tu2Field = new JTextField();
        inputPanel.add(tu2Field);
        inputPanel.add(new JLabel("Mau so 2:"));
        mau2Field = new JTextField();
        inputPanel.add(mau2Field);

        content.add(inputPanel);
        content.add(Box.createRigidArea(new Dimension(0,10)));

        JPanel buttonPanel = new JPanel(new GridLayout(1,4,8,8));
        JButton btnCong = new JButton("+");
        JButton btnTru = new JButton("-");
        JButton btnNhan = new JButton("x");
        JButton btnChia = new JButton("/");
        buttonPanel.add(btnCong);
        buttonPanel.add(btnTru);
        buttonPanel.add(btnNhan);
        buttonPanel.add(btnChia);
        content.add(buttonPanel);
        content.add(Box.createRigidArea(new Dimension(0,10)));

        ketQuaLabel = new JLabel("Ket qua: ");
        ketQuaLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
        ketQuaLabel.setPreferredSize(new Dimension(260,60));
        ketQuaLabel.setVerticalAlignment(SwingConstants.TOP);
        ketQuaLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        content.add(ketQuaLabel);

        add(content);
        pack();
        setLocationRelativeTo(null); // can giua man hinh

        // Action listener chung
        ActionListener action = e -> {
            try {
                String sTu1 = tu1Field.getText().trim();
                String sMau1 = mau1Field.getText().trim();
                String sTu2 = tu2Field.getText().trim();
                String sMau2 = mau2Field.getText().trim();

                int t1 = Integer.parseInt(sTu1);
                int m1 = Integer.parseInt(sMau1);
                int t2 = Integer.parseInt(sTu2);
                int m2 = Integer.parseInt(sMau2);

                Phanso_121 ps1 = new Phanso_121(t1, m1);
                Phanso_121 ps2 = new Phanso_121(t2, m2);
                Phanso_121 kq = null;
                String op = "";

                Object src = e.getSource();
                if (src == btnCong) { kq = ps1.cong(ps2); op = "+"; }
                else if (src == btnTru) { kq = ps1.tru(ps2); op = "-"; }
                else if (src == btnNhan) { kq = ps1.nhan(ps2); op = "x"; }
                else if (src == btnChia) { kq = ps1.chia(ps2); op = "/"; }

                ketQuaLabel.setText("<html>Ket qua:<br/>" 
                        + ps1.toString() + " " + op + " " + ps2.toString()
                        + " = <b>" + kq.toString() + "</b></html>");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nhap phai la so nguyen!", "Loi", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Loi", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Co loi xay ra: " + ex.getMessage(), "Loi", JOptionPane.ERROR_MESSAGE);
            }
        };

        btnCong.addActionListener(action);
        btnTru.addActionListener(action);
        btnNhan.addActionListener(action);
        btnChia.addActionListener(action);
    }

    public static void main(String[] args) {
        // Chay tren Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new Main_121().setVisible(true);
        });
    }
}
