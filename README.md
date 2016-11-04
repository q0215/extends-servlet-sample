# ExtendServlet

既存の資材には触れないという無茶振りに応えるためのWrapperを使ったServlet実装。  
TestServletを既存Servletとして扱ってます。
  
要件は大きく分けて以下の2つ。
* リクエストボディをTestServlet実行前に読み込んでなんらかの処理を入れたい。
* 既存ではTestServletにてレスポンスボディを書き込んでいるが、内容を見てレスポンスを作成したい。
  
実装方針は以下のとおり。
* リクエストを先に読み込み、保持する。TestServletでの入力ストリーム取得時には保持した内容を別のストリームに食わせて渡す。
* TestServletではレスポンスが書き込まれないようにし、内部で保持させる。実際のレスポンス書き込みは別名のメソッドを用意。
  
未実装部分
* 実際のレスポンス書き込みは別名のメソッドを用意。
