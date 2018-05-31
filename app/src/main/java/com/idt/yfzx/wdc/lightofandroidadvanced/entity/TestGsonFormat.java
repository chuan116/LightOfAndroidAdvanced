package com.idt.yfzx.wdc.lightofandroidadvanced.entity;

import java.util.List;

/**
 * @author 王大川
 * @createTime 2018/5/30
 * <p>
 * description：
 */
public class TestGsonFormat {


    /**
     * a : b
     * c : {"c":"d"}
     * d : [{"a":"g"},{"c":"h"}]
     */

    private String a;
    private CBean c;
    private List<DBean> d;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public CBean getC() {
        return c;
    }

    public void setC(CBean c) {
        this.c = c;
    }

    public List<DBean> getD() {
        return d;
    }

    public void setD(List<DBean> d) {
        this.d = d;
    }

    public static class CBean {
        /**
         * c : d
         */

        private String c;

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }
    }

    public static class DBean {
        /**
         * a : g
         * c : h
         */

        private String a;
        private String c;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }
    }
}
