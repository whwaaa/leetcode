/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/13
 * @Week: 星期一
 */
public class 扩容背包 {

    public static void main2(String[] args) {
        int bu = 142;       // 24个
        int shuzhi = 15;    // 96个
        int xiaoshi = 84;   // 24个
        int majinggan = 11; // 24个
        int shoujing = 60;  // 13个
        int sell = 15919;
        int cb0 = bu * 24 + shuzhi * 96 + xiaoshi * 24 + majinggan * 24 + shoujing * 13;
        int cb1 = bu * 24 + xiaoshi * 24 + majinggan * 24 + shoujing * 13;
        System.out.println("布    (24个)   124*24 -> " + bu * 24);
        System.out.println("树脂  (96个)   15*96 -> " + shuzhi * 96);
        System.out.println("硝石  (84个)   84*24 -> " + xiaoshi * 24);
        System.out.println("麻茎杆 (24个)  11*24 -> " + majinggan * 24);
        System.out.println("兽筋  (13个)   60*13 -> " + shoujing * 13);
        System.out.println("购买兽筋成本:" + cb0 + "  出售:" + sell + "  扣除20%手续费赚取:" + (int) (sell * (1 - 0.2) - cb0));
        System.out.println("自打兽筋成本:" + cb1 + "  出售:" + sell + "  扣除20%手续费赚取:" + (int) (sell * (1 - 0.2) - cb1));
    }


    public static void main(String[] args) {
        int 采集券 = 0;
        int 营地贡献度 = 0;
        int 新币 = 0;

        int 六角钉 = 8;
        int 生铁 = 2;
        int 铁矿 = 0;
        int 小树枝 = 0;
        int 硬木藤蔓 = 0;
        int 骨头 = 0;
        int 金条 = 0;
        for(int i=0; i<六角钉; i++){
            // 生铁 += 2;
            for(int j=0; j<生铁; j++){
                铁矿 += 2;
                小树枝 += 4;
            }
            硬木藤蔓 += 4;
            骨头 += 2;
        }
        System.out.println("六角钉(x"+ 六角钉 +")造费:");
        System.out.println("铁矿: x" + 铁矿 + " 采集券:30*" + 铁矿 + " -> " +铁矿*30);
        采集券 += 铁矿*30;
        System.out.println("小树枝: x" + 小树枝 + "  -> 蹭我的免费");
        System.out.println("硬木藤蔓: x" + 硬木藤蔓 + " 采集券:60*"+ 硬木藤蔓 + " -> " +硬木藤蔓*60);
        采集券 += 硬木藤蔓*60;
        System.out.println("骨头: x" + 骨头 + " 采集券:50*"+ 骨头 + " -> " +骨头*50);
        采集券 += 骨头*50;


        int 塑料 = 8;
        int 树脂 = 0;
        int 硝石 = 0;
        int 布 = 0;
        int 植物根茎 = 0;
        int 麻 = 0;
        int 麻茎杆 = 0;
        int 麻茎皮 = 0;
        for(int i=0; i<塑料; i++){
            树脂 += 8;
            硝石 += 2;
            麻茎皮 += 1;
            麻 += 15;
            植物根茎 += 2;
            麻茎杆 += 2;
        }
        System.out.println();
        System.out.println("塑料(x"+ 塑料 +")造费:");
        System.out.println("树脂: x" + 树脂 + " 采集券:29*"+ 树脂 + " -> " +树脂*29);
        采集券 += 树脂*29;
        System.out.println("硝石: x" + 硝石 + " 金条:110*" + 硝石 + " -> " + 硝石*110);
        金条 += 硝石*110;
        System.out.println("麻茎皮: x" + 麻茎皮 + " 采集券:96"+ 麻茎皮 + " -> " +麻茎皮*96);
        采集券 += 麻茎皮*96;
        System.out.println("麻: x" + 麻);
        System.out.println("植物根茎: x" + 植物根茎 + " 采集券:36"+ 植物根茎 + " -> " +植物根茎*36);
        采集券 += 植物根茎*36;
        System.out.println("麻茎杆: x" + 麻茎杆 + " 采集券:39"+ 麻茎杆 + " -> " +麻茎杆*39);
        采集券 += 麻茎杆*39;
        System.out.println("\n钢管(x6): 金条:864*6 -> " + 864*6);
        金条 += 864*6;
        System.out.println("\n玻璃(x6): 营地贡献度:90*6 -> " + 90*6 + "   新币:30*6 -> " + 30*6);
        营地贡献度 += 90*6;
        新币 += 30*6;
        System.out.println("\n需采集券: " + 采集券);
        System.out.println("需金条: " + 金条);
        System.out.println("需营地贡献: " + 营地贡献度);
        System.out.println("新币: " + 新币);
        System.out.println("麻: " + 麻);


    }

}
