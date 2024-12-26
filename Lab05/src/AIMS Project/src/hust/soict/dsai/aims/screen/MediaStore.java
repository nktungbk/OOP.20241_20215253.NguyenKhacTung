package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore  extends JPanel{
	private Media media;
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton cart = new JButton("Add to Cart");
		
		if (media instanceof Playable) {
			JButton play = new JButton("Play");
			play.addActionListener(new MediaHome());
			container.add(play);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
	}
	public class MediaHome implements ActionListener{
		JFrame f = new JFrame();
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String s = e.getActionCommand();
			if (s.equals("Play")) {
				JDialog d = new JDialog(f,"Play Dialog");
				
				JLabel l = new JLabel(media.toString());
				d.add(l);
				d.setSize(720,500);
				d.setVisible(true);
			} else if (s.equals("Add to Cart")) {
				JDialog d = new JDialog(f, "Add media to Cart Announcement");
				
				JLabel l = new JLabel("Add successfully");
				d.add(l);
				d.setSize(720,500);
				d.setVisible(true);
			}
		}
	}

}
