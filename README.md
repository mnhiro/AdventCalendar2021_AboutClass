# Advent Calendar 2021
記事用のサンプルです。
クローンしてあげると実行可能の状態になっていると思います。

主にRecyclerViewを使った一覧を表示しています。
どのような一覧画面を見れるかはQiitaの[レコチョクのAdvent Calendar 2021](https://qiita.com/advent-calendar/2021/recochoku)の[9日目](https://qiita.com/monhiromu/items/37540ebdadc4291268f4)を確認してみてください。

## ディレクトリ階層について
- model
- ui

### modelディレクトリ
このディレクトリには一覧で表示するデータのクラスを置いています。
Image, Movie, Musicではサンプルデータを作成する関数があるのでそちらで擬似的なデータを作ります。
サンプルデータを実際の楽曲・動画・画像に変えることで実際に一覧画面を作るときの参考にもできるかと思います。

### uiディレクトリ
uiディレクトリにはアダプターとMainActivityを置いています。
またBindingViewHolderというViewDataBindingを持たせたViewHolderを定義しています。
