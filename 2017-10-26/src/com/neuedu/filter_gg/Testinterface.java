package com.neuedu.filter_gg;
/**
 * java8֮��ӿ��п���дʵ�ַ���,�����й���
 * 1.��д��̬����
 * 2.Ĭ��ʵ�ַ���default
 * @author neuedu
 *
 */
public interface Testinterface {
	public static void add(){
		System.out.println("���ǽӿ��еľ�̬����");
	}
	
	public default void adddefault(){
		System.out.println(1);
	}
	
	
	
}
