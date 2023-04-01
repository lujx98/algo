package com.lu.dmsxl.twopointer;

import com.lu.structure.ListNode;

import java.util.Objects;

/**
 *  相信大家出错基本都是认为这是个简单的26进制转换，但是却在701（或者是52）这里出了问题
 *
 *  A@Y: 701=1 \times 26^2 + 0 \times 26^1 + 25 \times 26^0
 *  A@Y:701=1×26
 *  2
 *  +0×26
 *  1
 *  +25×26
 *  0
 *
 *
 *  ZY: 701=26 \times 26^1 + 25 \times 26^0
 *  ZY:701=26×26
 *  1
 *  +25×26
 *  0
 *
 *
 *  显然下面这个才是我们想要的，问题就出在当余数为0时，我们不能取@而是应该取Z，所以：
 *
 *
 *
 *  作者：Mrliuxchn
 *  链接：
 *  来源：力扣（LeetCode）
 *  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author sheldon
 * @date 2022-09-19
 * https://leetcode.cn/problems/excel-sheet-column-title/solution/ge-ren-ren-wei-ying-gai-shi-zui-hao-li-j-hjpy/
 */
public class Two_q160_2_GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int aCount = 0;
        ListNode tempA = headA;
        while (tempA.next != null) {
            tempA = tempA.next;
            aCount++;
        }
        int bCount = 0;
        ListNode tempB = headB;
        while (tempB.next != null) {
            tempB = tempB.next;
            bCount++;
        }

        int dif = aCount - bCount;
        if (dif > 0) {
            for (int i = 0; i < dif; i++) {
                headA = headA.next;
            }
        } else if (dif < 0) {
            for (int i = 0; i < -dif; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null && !Objects.equals(headA, headB)) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
//
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode temp = headA;
//        ListNode temp1 = headB;
//        while (temp.next !=null && temp1.next != null) {
//            temp = temp.next;
//            temp1 = temp1.next;
//        }
//        boolean isB = false;
//        int remain = 0;
//        if (temp.next == null) {
//            isB = true;
//            while (temp1.next != null) {
//                remain++;
//                temp1 = temp1.next;
//            }
//        } else {
//            while (temp.next != null) {
//                remain++;
//                temp = temp.next;
//            }
//        }
//        for (int i = 0; i < remain; i++) {
//            if (isB) {
//
//                headB = headB.next;
//            } else {
//                headA = headA.next;
//            }
//        }
//        while (headA != headB) {
//            if (headA == null && headB == null) {
//                return null;
//            }
//            headA = headA.next;
//            headB = headB.next;
//        }
//        return headA;
//    }

}
