package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeWrite {
	public static void main(String[] args) throws IOException {
		String text="www.sina.com";
		int width=60;
		int height=60;
		String format="png";
		Hashtable<EncodeHintType,Object> hints=new Hashtable<EncodeHintType,Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		try {
			BitMatrix bitMatrix=new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
			Path file=new File("D:/new.png").toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (WriterException e) {
			e.printStackTrace();
		}
	}
}
