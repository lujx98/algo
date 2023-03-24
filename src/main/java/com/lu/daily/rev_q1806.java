package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-09
 */
public class rev_q1806 {

    @Test
    public void test(){

    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10; j++) {
                if (i < 10) {
                    System.err.println("ALTER TABLE `collection_contacts_0" + i + "_db`.`t_collection_contacts_" + j + "` ADD COLUMN `Fchannel` varchar(64) NOT NULL DEFAULT 'kredito' COMMENT '渠道' AFTER `Fuid`;");
                } else {
                    System.err.println("ALTER TABLE `collection_contacts_" + i + "_db`.`t_collection_contacts_" + j + "` ADD COLUMN `Fchannel` varchar(64) NOT NULL DEFAULT 'kredito' COMMENT '渠道' AFTER `Fuid`;");
                }
            }
        }
    }

    public int reinitializePermutation(int n) {
        int res = 0;
        while (true) {

        }
    }

}
