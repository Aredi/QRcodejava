import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;



public class Stand extends JButton{
	private int x;
	private int y;
	private  String textQR;
	private int compteurStand=0;
	
	public Stand(){
		compteurStand++;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setTextQR(String textQR) {
		this.textQR = textQR;
	}
	
	
	public void creerImageQRcode() throws WriterException, IOException{
		 String data = textQR;
	        int size = 200;
	        // encode
	        String imageFormat = "png";
	        String compteurTest = String.valueOf(compteurStand);
	        String outputFileName = "/home/administrateur/QRStock28" + imageFormat + compteurTest;
	        // write in a file
	        BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
	        FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFileName));
	        MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, fileOutputStream);
	        fileOutputStream.close();
	}
	
	public void afficher(JFrame frame){
		
	}
	

	
	
	
}