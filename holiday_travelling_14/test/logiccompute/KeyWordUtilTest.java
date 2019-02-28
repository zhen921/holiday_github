package logiccompute;

import static org.junit.Assert.*;

import org.junit.Test;

import user.logiccompute.KeyWordUtil;

public class KeyWordUtilTest {

	@Test
	public void testGetKeyWord() {
		System.out.println(new KeyWordUtil(null).getKeyWord("张家界风景区"," 张家界名胜区风景区景区"));
	}

}
