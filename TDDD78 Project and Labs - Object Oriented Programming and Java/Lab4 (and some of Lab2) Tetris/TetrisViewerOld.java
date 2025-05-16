package se.liu.jeand987.tetris;

import javax.swing.*;
import java.awt.*;

public class TetrisViewerOld
{
    private JFrame frame;
    private JTextArea textarea;
    private Board board;

    public TetrisViewerOld(Board board) {
	this.board = board;
	frame = new JFrame("Tetris");
	textarea = new JTextArea(board.getWidth(), board.getHeight());
    }
    public void show(){
	BoardToTextConverter tetrisText = new BoardToTextConverter();

	textarea.setText(tetrisText.convertToText(board));
	frame.setLayout(new BorderLayout());
	frame.add(textarea, BorderLayout.CENTER);
	textarea.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	frame.pack(); frame.setVisible(true);

    }

}
