package com.ss.interview.bytedance;

import java.util.Scanner;

/**
 * @author Senn
 * @date 2022/9/25 19:20
 * 江森森，去年毕业生。曾在字节跳动（ab实验-广告侧-数据科学性组）实习半年，负责显著性计算工具支持美国侧数据开发，SKAN专项综合报告离线链路设计与实现。
 * 毕业后进入腾讯云智，在腾讯位置服务的控制台模块负责开发（golang），
 * 毕业半年后成为 营销拓客平台的总负责人，负责数据库设计，接口设计，技术选型等等，平台上线后，（java）
 * 因其支撑了腾讯位置服务的商业授权的售卖成为了腾旭位置服务的核心项目，按数据量估计1%转化即可实现今年5000w收益目标，后维护2-3的版本趋于稳定。
 * 营销平台趋于稳定后，准备接手负责文旅业务。开发了数字故宫的个性化路线需求。
 * 因地图应用产品中心收益目标未到达，业务调整，被优化。。。
 * 主要负责java开发与go开发，希望找一个后端的开发工作，语言为java或者go。
 */
public class T_01_0925 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int[] tem = nums[i];
            int m = Math.abs(tem[1] - tem[0]);
            if (m <= 0) {
                System.out.println(0);
                continue;
            }
            int step = 0;
            int index = 1;
            while (m > 0) {
                if (m - 2 * index >= 0) {
                    m -= 2 * index;
                    index++;
                    step += 2;
                }else {
                    if (Math.abs(m - index) <= 1) {
                        m = 0;
                        step++;
                    }else {
                        m = m - index;
                        step++;
                    }
                }
            }
            System.out.println(step);
        }
    }
}
