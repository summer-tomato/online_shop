package jp.practice.sales;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品データ全体を保持するクラス
 */
public final class RecordManager {

    /** 商品データ */
    private static List<Item> list = new ArrayList<>();
    static {
        list.add(new Item("A00101", "油性ボールペン", 60, 0, 0));
        list.add(new Item("A00201", "極細ボールペン", 120, 0, 0));
        list.add(new Item("A00301", "蛍光ペン６色セット", 420, 0, 0));
        list.add(new Item("A00401", "シャープペンシル", 100, 0, 0));
        list.add(new Item("A00501", "鉛筆H（１ダース）", 400, 0, 0));
        list.add(new Item("B00101", "無線綴ノートA4", 100, 0, 0));
        list.add(new Item("B00201", "リングノートA4", 120, 0, 0));
        list.add(new Item("B00301", "領収書", 350, 0, 0));
        list.add(new Item("C00101", "はさみ（青）", 128, 0, 0));
        list.add(new Item("C00201", "ステープラー", 338, 0, 0));
        list.add(new Item("C00301", "２穴パンチ", 128, 0, 0));
        list.add(new Item("C00401", "ゼムクリップ", 98, 0, 0));
        list.add(new Item("C00501", "消しゴム", 58, 0, 0));
    }

    /**
     * 引数で指定された商品名に一致する商品データを返却
     * @param goodsName 検索キーとなる商品名
     * @return 検索結果の商品データ
     */
    public static Item findItem(String goodsName) {
    	int index = list.indexOf(new Item("", goodsName, 0, 0, 0));
    	return list.get(index);
    }

    /**
     * 商品の名前のリストを返す。
     * @return 名前の配列
     */
    public static String[] makeNameList() {
        String[] nameList = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nameList[i] = (list.get(i)).getName();
        }
        return nameList;
    }

	/**
	 * プルダウンリストの初期値セットデータを取得する
     * @return 先頭の商品の名前
	 */
	public static String getFirstItemName() {
		return  list.get(0).getName();
	}

}
//Copyright 2016-2021 FUJITSU APPLICATIONS LIMITED
