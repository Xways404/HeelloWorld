public class SwitchDetail {
	public static void main(String[] args) {
		
		// 式のデータ型は、case の後にある定数の型と一致している必要がある。
		// または、自動的に比較可能な型に変換できる必要がある
		
		//case　はデータ型出なければならない、変量じゃ実行不可
		
		//defalt　は選択可能であり、case 定数と一致するものがない場合、defaltを実行

		
		//switch(式) 中の式の戻り値は、以下のいずれかでなければならない：
		//（byte，short，int，char，enum，String）
		
		// break 文は、一つの case の実行が完了した後にスイッチ文ブロックから抜き。
		// break 文がない場合、プログラムは switch の終わりまで順次実行される。

		char c = 'a';
		switch(c) {
			case 'a' :
				System.out.println("ok1");
				break;
			case 'b':
				System.out.println("ok2");
				break;
			default :
				System.out.println("ok3");
		}
		System.out.println("hhjjj");
	}
}