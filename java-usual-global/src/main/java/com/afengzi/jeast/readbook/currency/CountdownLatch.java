package com.afengzi.jeast.readbook.currency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-28
 * Time: ����2:54
 * To change this template use File | Settings | File Templates.
 */
public class CountdownLatch {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool(); //����һ���̳߳�
        final CountDownLatch cdOrder = new CountDownLatch(1);//ָ�ӹٵ��������Ϊ1��ָ�ӹ�һ�´������cutDown,��Ϊ0��սʿ��ִ������

        final CountDownLatch cdAnswer = new CountDownLatch(3);//��Ϊ������սʿ�����Գ�ʼֵΪ3��ÿһ��սʿִ�����������cutDownһ�Σ���������ִ����ϣ���Ϊ0����ָ�ӹ�ֹͣ�ȴ���
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {

                public void run() {
                    try {
                        System.out.println("�߳�" + Thread.currentThread().getName() +
                                "��׼����������");
                        cdOrder.await(); //սʿ�Ƕ����ڵȴ�����״̬
                        System.out.println("�߳�" + Thread.currentThread().getName() +
                                "�ѽ�������");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("�߳�" + Thread.currentThread().getName() +
                                "��Ӧ�������");
                        cdAnswer.countDown(); //����ִ����ϣ����ظ�ָ�ӹ٣�cdAnswer��1��

                    } catch (Exception e) {
                        e.printStackTrace();

                    }

                }


            };
            service.execute(runnable);//Ϊ�̳߳��������

        }
        try {
            Thread.sleep((long) (Math.random() * 10000));

            System.out.println("�߳�" + Thread.currentThread().getName() +
                    "������������");
            cdOrder.countDown(); //�������cdOrder��1�����ڵȴ���սʿ��ֹͣ�ȴ�תȥִ������
            System.out.println("�߳�" + Thread.currentThread().getName() +
                    "�ѷ���������ڵȴ����");
            cdAnswer.await(); //����ͺ�ָ�ӹٴ��ڵȴ�״̬��һ��cdAnswerΪ0ʱֹͣ�ȴ���������ִ��
            System.out.println("�߳�" + Thread.currentThread().getName() +
                    "���յ�������Ӧ���");

        } catch (Exception e) {
            e.printStackTrace();

        }
        service.shutdown(); //���������ֹͣ�̳߳ص������߳�


    }
}
