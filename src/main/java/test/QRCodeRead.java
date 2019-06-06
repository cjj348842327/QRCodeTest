package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QRCodeRead {
	public static void main(String[] args) throws NotFoundException {
		MultiFormatReader formatReader=new MultiFormatReader();
		File file =new File("D:/new.png");
		BufferedImage image=null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BinaryBitmap binaryBitmap =new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
		Hashtable<DecodeHintType,Object> hints=new Hashtable<DecodeHintType,Object>();
		hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
		Result result=formatReader.decode(binaryBitmap,hints);
		System.err.println("解析结果："+result.toString());
		System.out.println(result.getBarcodeFormat());
		System.out.println(result.getText());
	}
}
