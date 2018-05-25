package com.project.zaixianjiaoyu.weixin.order;

/**
 * <strong>����֧��</strong><br>
 * <br>
 *
 * �����˺�ID appid String(32) �� wx8888888888888888 ΢�ŷ���Ĺ����˺�ID <br>
 * <br>
 *
 * �̻��� partnerid String(32) �� 1900000109 ΢��֧��������̻��� <br>
 * <br>
 *
 * Ԥ֧�����׻ỰID prepayid String(32) �� WX1217752501201407033233368018 ΢�ŷ��ص�֧�����׻ỰID <br>
 * <br>
 *
 * ��չ�ֶ� package String(128) �� Sign=WXPay ����д�̶�ֵSign=WXPay <br>
 * <br>
 *
 * ����ַ��� noncestr String(32) �� 5K8264ILTKCH16CQ2502SI8ZNMTM67VS
 * ����ַ�����������32λ���Ƽ�����������㷨 <br>
 * <br>
 *
 * ʱ��� timestamp String(10) �� 1412000000 ʱ���������ӿڹ���-�����涨 <br>
 * <br>
 *
 * ǩ�� sign String(32) �� C380BEC2BFD727A4B6845133519F3AD6 ǩ�������ǩ�������㷨 <br>
 * <br>
 *
 * @author �쳯��
 */
public class StartOrder extends Order {

	private static final long serialVersionUID = 1L;

	/**
	 * �����˺�ID appid String(32) �� wx8888888888888888 ΢�ŷ���Ĺ����˺�ID
	 */
	public static final String APP_ID = "appid";

	/**
	 * �̻��� partnerid String(32) �� 1900000109 ΢��֧��������̻���
	 */
	public static final String PARTNER_ID = "partnerid";

	/**
	 * Ԥ֧�����׻ỰID prepayid String(32) �� WX1217752501201407033233368018 ΢�ŷ��ص�֧�����׻ỰID
	 */
	public static final String PREPAY_ID = "prepayid";

	/**
	 * ��չ�ֶ� package String(128) �� Sign=WXPay ����д�̶�ֵSign=WXPay
	 */
	public static final String PACKAGE = "package";

	/**
	 * ����ַ��� noncestr String(32) �� 5K8264ILTKCH16CQ2502SI8ZNMTM67VS
	 * ����ַ�����������32λ���Ƽ�����������㷨
	 */
	public static final String NONCESTR = "noncestr";

	/**
	 * ʱ��� timestamp String(10) �� 1412000000 ʱ���������ӿڹ���-�����涨
	 */
	public static final String TIMES_TAMP = "timestamp";

	/**
	 * ǩ�� sign String(32) �� C380BEC2BFD727A4B6845133519F3AD6 ǩ�������ǩ�������㷨
	 */
	public static final String SIGN = "sign";

}
