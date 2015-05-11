package frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import composite.Shape;
import javax.swing.JSlider;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ApplicationWindow {

	private JFrame frame;
	private JComboBox<Shape> shapeBox;
	private Color selectedColor;
	private JPanel showColor;
	private JSlider sliderGreen;
	private JSlider sliderRed;
	private JSlider sliderBlue;
	private JScrollPane scrollPane;
	private Canvas canvas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblShape = new JLabel("Shape:");
		
		shapeBox = new JComboBox<Shape>();
		selectedColor = new Color(100, 100, 100);
		
		JPanel colorPanel = new JPanel();
		canvas = new Canvas();
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(canvas);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(shapeBox, 0, 133, Short.MAX_VALUE)
						.addComponent(lblShape, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addComponent(colorPanel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
					.addGap(8))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblShape)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(shapeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(colorPanel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		colorPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblColor = new JLabel("Color:");
		colorPanel.add(lblColor, "2, 2");
		
		showColor = new JPanel();
		showColor.setBackground(selectedColor);
		colorPanel.add(showColor, "4, 2, fill, fill");
		
		JLabel lblRed = new JLabel("Red:");
		colorPanel.add(lblRed, "2, 4");
		
		sliderRed = new JSlider();
		sliderRed.setMaximum(255);
		colorPanel.add(sliderRed, "4, 4");
		
		JLabel lblGreen = new JLabel("Green:");
		colorPanel.add(lblGreen, "2, 6");
		
		sliderGreen = new JSlider();
		sliderGreen.setMaximum(255);
		colorPanel.add(sliderGreen, "4, 6");
		
		JLabel lblBlue = new JLabel("Blue:");
		colorPanel.add(lblBlue, "2, 8");
		
		sliderBlue = new JSlider();
		sliderBlue.setMaximum(255);
		colorPanel.add(sliderBlue, "4, 8");
		frame.getContentPane().setLayout(groupLayout);
		
		sliderRed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				selectedColor = new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue());
				showColor.setBackground(selectedColor);
			}
		});
		sliderGreen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				selectedColor = new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue());
				showColor.setBackground(selectedColor);
			}
		});
		sliderBlue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				selectedColor = new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue());
				showColor.setBackground(selectedColor);
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
	}
}
