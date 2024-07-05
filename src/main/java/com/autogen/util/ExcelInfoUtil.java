package com.autogen.util;

public class ExcelInfoUtil {
    public static String[] COLUMN_RANGE_ARRAY ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V",
            "W","X","Y","Z","AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO",
            "AP","AQ","AR","AS","AT","AU","AV","AW","AX","AY","AZ","BA","BB","BC","BD","BE","BF","BG","BH",
            "BI","BJ","BK","BL","BM","BN","BO","BP","BQ","BR","BS","BT","BU","BV","BW","BX","BY","BZ"};

    public static double[][][] CPZB_weight_ARRAY = {{{0.4,0.4,0.0},{0.4,0.4,0.4,0.4,0.0},{0.4,0.0,0.4,0.0,0.4,0.0},{0.4,0.4,0.0,0.4,0.4,0.4,0.4,0.0}},//测评指标权重表；第一个维度为密评过第几级，第二个维度为安全层面，第三个维度为测评单元
                                                    {{0.7,0.4,0.0},{0.7,0.4,0.7,0.4,0.0},{0.7,0.0,0.4,0.0,0.4,0.0},{0.7,0.4,0.0,0.7,0.7,0.7,0.7,0.0}},
                                                    {{1.0,0.7,0.7},{1.0,0.7,1.0,0.4,0.4},{1.0,1.0,0.4,0.4,0.4,0.7},{1.0,0.4,0.4,1.0,1.0,0.7,0.7,1.0}},
                                                    {{1.0,0.7,0.7},{1.0,1.0,1.0,0.7,0.7},{1.0,1.0,0.7,0.7,0.7,1.0},{1.0,0.7,0.7,1.0,1.0,1.0,1.0,1.0}}};
    public static int ROW_START_NUMBER = 1;
    public static int ROW_END_NUMBER = 35;
    public static int READ_CPDX_START_NUMBER = 4;   //COLUMN_RANGE_ARRAY[4]
    public static int DAK_JUMP = 3;
}
