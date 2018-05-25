package com.project.zaixianjiaoyu.weixin.order;

/**
 * <strong>ͳһ �µ�</strong><br>
 * <br>
 *
 * �����˺�ID appid �� String(32) wx8888888888888888 ΢�ŷ���Ĺ����˺�ID <br>
 * <br>
 *
 * �̻��� mch_id �� String(32) 1900000109 ΢��֧��������̻��� <br>
 * <br>
 *
 * �豸�� device_info �� String(32) 013467007045764
 * �ն��豸��(�ŵ�Ż������豸ID)��ע�⣺PC��ҳ���ں���֧���봫"WEB" <br>
 * <br>
 *
 * ����ַ��� nonce_str �� String(32) 5K8264ILTKCH16CQ2502SI8ZNMTM67VS
 * ����ַ�����������32λ���Ƽ�����������㷨 <br>
 * <br>
 *
 * ǩ�� sign �� String(32) C380BEC2BFD727A4B6845133519F3AD6 ǩ�������ǩ�������㷨 <br>
 * <br>
 *
 * ��Ʒ���� body �� String(32) Ipad mini 16G ��ɫ ��Ʒ��֧������Ҫ���� <br>
 * <br>
 *
 * ��Ʒ���� detail �� String(8192) Ipad mini 16G ��ɫ ��Ʒ������ϸ�б� <br>
 * <br>
 *
 * �������� attach �� String(127) ˵�� �������ݣ��ڲ�ѯAPI��֧��֪ͨ��ԭ�����أ����ֶ���Ҫ�����̻�Я���������Զ������� <br>
 * <br>
 *
 * �̻������� out_trade_no �� String(32) 1217752501201407033233368018
 * �̻�ϵͳ�ڲ��Ķ�����,32���ַ��ڡ��ɰ�����ĸ, ����˵�����̻������� <br>
 * <br>
 *
 * �������� fee_type �� String(16) CNY ����ISO 4217��׼����λ��ĸ���룬Ĭ������ң�CNY������ֵ�б������������ <br>
 * <br>
 *
 * �ܽ�� total_fee �� Int 888 �����ܽ�ֻ��Ϊ���������֧����� <br>
 * <br>
 *
 * �ն�IP spbill_create_ip �� String(16) 8.8.8.8
 * APP����ҳ֧���ύ�û���ip��Native֧�������΢��֧��API�Ļ���IP�� <br>
 * <br>
 *
 * ������ʼʱ�� time_start �� String(14) 20091225091010
 * ��������ʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��25��9��10��10���ʾΪ20091225091010���������ʱ����� <br>
 * <br>
 *
 * ���׽���ʱ�� time_expire �� String(14) 20091227091010
 * ����ʧЧʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��27��9��10��10���ʾΪ20091227091010���������ʱ����� <br>
 * <br>
 *
 * ��Ʒ��� goods_tag �� String(32) WXG ��Ʒ��ǣ�����ȯ�������Żݹ��ܵĲ�����˵���������ȯ�������Ż� <br>
 * <br>
 *
 * ֪ͨ��ַ notify_url �� String(256) http://www.baidu.com/ ����΢��֧���첽֪ͨ�ص���ַ <br>
 * <br>
 *
 * �������� trade_type �� String(16) JSAPI ȡֵ���£�JSAPI��NATIVE��APP��WAP,��ϸ˵���������涨 <br>
 * <br>
 *
 * ��ƷID product_id �� String(32) 12235413214070356458058
 * trade_type=NATIVE���˲����ش�����idΪ��ά���а�������ƷID���̻����ж��塣 <br>
 * <br>
 *
 * �û���ʶ openid �� String(128) oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
 * trade_type=JSAPI���˲����ش����û����̻�appid�µ�Ψһ��ʶ���µ�ǰ��Ҫ���á���ҳ��Ȩ��ȡ�û���Ϣ���ӿڻ�ȡ���û���Openid <br>
 * <br>
 *
 * URL���� long_url �� String(512)
 * weixin://wxpay/bizpayurl?sign=XXXXX&appid=XXXXX&mch_id
 * =XXXXX&product_id=XXXXXX&time_stamp=XXXXXX&nonce_str=XXXXX
 * ��Ҫת����URL��ǩ����ԭ����������URL encode <br>
 * <br>
 *
 * @author �쳯��
 */
public class AddOrder extends Order {

	private static final long serialVersionUID = 1L;

	/**
	 * �����˺�ID appid �� String(32) wx8888888888888888 ΢�ŷ���Ĺ����˺�ID
	 */
	public static String APPID = "appid";

	/**
	 * �̻��� mch_id �� String(32) 1900000109 ΢��֧��������̻���
	 */
	public static String MCH_ID = "mch_id";

	/**
	 * �豸�� device_info �� String(32) 013467007045764
	 * �ն��豸��(�ŵ�Ż������豸ID)��ע�⣺PC��ҳ���ں���֧���봫"WEB"
	 */
	public static String DEVICE_INFO = "device_info";

	/**
	 * ����ַ��� nonce_str �� String(32) 5K8264ILTKCH16CQ2502SI8ZNMTM67VS
	 * ����ַ�����������32λ���Ƽ�����������㷨
	 */
	public static String NONCE_STR = "nonce_str";

	/**
	 * ǩ�� sign �� String(32) C380BEC2BFD727A4B6845133519F3AD6 ǩ�������ǩ�������㷨
	 */
	public static String SIGN = "sign";

	/**
	 * Ʒ���� body �� String(32) Ipad mini 16G ��ɫ ��Ʒ��֧������Ҫ����
	 */
	public static String BODY = "body";

	/**
	 * ��Ʒ���� detail �� String(8192) Ipad mini 16G ��ɫ ��Ʒ������ϸ�б�
	 */
	public static String DETAIL = "detail";

	/**
	 * �������� attach �� String(127) ˵�� �������ݣ��ڲ�ѯAPI��֧��֪ͨ��ԭ�����أ����ֶ���Ҫ�����̻�Я���������Զ�������
	 */
	public static String ATTACH = "attach";

	/**
	 * �̻������� out_trade_no �� String(32) 1217752501201407033233368018
	 * �̻�ϵͳ�ڲ��Ķ�����,32���ַ��ڡ��ɰ�����ĸ, ����˵�����̻�������
	 */
	public static String OUT_TRADE_NO = "out_trade_no";

	/**
	 * �������� fee_type �� String(16) CNY ����ISO 4217��׼����λ��ĸ���룬Ĭ������ң�CNY������ֵ�б������������
	 */
	public static String FEE_TYPE = "fee_type";

	/**
	 * �ܽ�� total_fee �� Int 888 �����ܽ�ֻ��Ϊ���������֧�����
	 */
	public static String TOTAL_FEE = "total_fee";

	/**
	 * �ն�IP spbill_create_ip �� String(16) 8.8.8.8
	 * APP����ҳ֧���ύ�û���ip��Native֧�������΢��֧��API�Ļ���IP��
	 */
	public static String SPBILL_CREATE_IP = "spbill_create_ip";

	/**
	 * ������ʼʱ�� time_start �� String(14) 20091225091010
	 * ��������ʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��25��9��10��10���ʾΪ20091225091010���������ʱ�����
	 */
	public static String TIME_START = "time_start";

	/**
	 * ���׽���ʱ�� time_expire �� String(14) 20091227091010
	 * ����ʧЧʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��27��9��10��10���ʾΪ20091227091010���������ʱ�����
	 */
	public static String TIME_EXPIRE = "time_expire";

	/**
	 * ��Ʒ��� goods_tag �� String(32) WXG ��Ʒ��ǣ�����ȯ�������Żݹ��ܵĲ�����˵���������ȯ�������Ż�
	 */
	public static String GOODS_TAG = "goods_tag";

	/**
	 * ֪ͨ��ַ notify_url �� String(256) http://www.baidu.com/ ����΢��֧���첽֪ͨ�ص���ַ
	 */
	public static String NOTIFY_URL = "notify_url";

	/**
	 * �������� trade_type �� String(16) JSAPI ȡֵ���£�JSAPI��NATIVE��APP��WAP,��ϸ˵���������涨
	 */
	public static String TRADE_TYPE = "trade_type";

	/**
	 * ��ƷID product_id �� String(32) 12235413214070356458058
	 * trade_type=NATIVE���˲����ش�����idΪ��ά���а�������ƷID���̻����ж��塣
	 */
	public static String PRODUCT_ID = "product_id";

	/**
	 * �û���ʶ openid �� String(128) oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
	 * trade_type=JSAPI���˲����ش����û����̻�appid�µ�Ψһ��ʶ���µ�ǰ��Ҫ���á���ҳ��Ȩ��ȡ�û���Ϣ���ӿڻ�ȡ���û���Openid
	 */
	public static String OPENID = "openid";

	/**
	 * URL���� long_url �� String(512)
	 * weixin://wxpay/bizpayurl?sign=XXXXX&appid=XXXXX&mch_id
	 * =XXXXX&product_id=XXXXXX&time_stamp=XXXXXX&nonce_str=XXXXX
	 * ��Ҫת����URL��ǩ����ԭ����������URL encode
	 */
	public static String LONG_URL = "long_url";

}
