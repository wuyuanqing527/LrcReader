# LrcReader
# 一款高效美观的歌词聚合搜索app

## 设计特色
- 操作便捷,为大屏单手操作优化：

所有常用的操作按钮都放置在下半屏或者以滑动操作代替，在如今6寸叫小屏的时代带来更便捷的操作体验。上半屏显示标题，状态以及放置不常用按钮如设置。

- 多种缓存机制使搜索更快速更省流量：

使用了内存+LruCache+数据库+文件的多种缓存，对搜索历史数据也进行缓存。以空间换时间，增加搜索速度的同时减少流量消耗。

在搜索时会首先对本地缓存文件进行匹配搜索。

- 人性化的设计细节：

 1. 喜欢支持不同喜欢程度设置，分为有点喜欢，喜欢与很喜欢三挡；

 2. 支持微信，朋友圈，微博的图片分享，随时随地分享感动自己的歌词；

 3. 支持文字大小，背景模糊程度等参数的调节，使分享的截图更好看，更完整；

 4. (未来支持短视频编辑，图片编辑分享等新形式，使分享更自由更好看。)


- 资源聚合：

音乐资源经过版权之争之后，不同的音乐版权都掌握在不同的厂家手里，经常会为了一首歌去下载一个新的APP，体验非常不好，所以我们通过技术手段达到一个资源聚合的目的，当然仅当学习使用**不以商业为目的**！

目前只支持歌词迷的后台API。

## 首页三大模块

###### 搜索
搜索页面显示之前的搜索记录

![](https://github.com/wuyuanqing527/LrcReader/blob/master/screenCapture/search_list.jpg)

![search](https://github.com/wuyuanqing527/LrcReader/blob/master/screenCapture/search.gif)

###### 喜欢

喜欢可以有多个等级或者场景，默认分为3个等级：有点喜欢，喜欢，很喜欢。
在首页的喜欢页面顶部可以根据喜欢等级进行列表筛选。

![like](https://github.com/wuyuanqing527/LrcReader/blob/master/screenCapture/like.mp4)

###### 本地

支持本地文件的扫描，支持指定文件夹。缓存所有搜索到的歌词文件。
对不同的歌词文件进行不同的解析。

## 歌词界面

歌词界面以专辑图片加以高斯模糊的效果为背景，通过沉浸式状态栏以及操作界面的隐藏达到界面只有歌词的纯净效果，给人以赏心悦目的观感。

操作界面可以通过双击界面或者底部上滑呼出,下滑或者点击X可以关闭。

- 支持微信，朋友圈，微博的分享
- 支持下载到本地，歌词文字大小调整，背景模糊程度调整，喜欢程度设置
- （后面会支持图片的编辑，文字的选择分享，短视频的生成与分享）

![operation](https://github.com/wuyuanqing527/LrcReader/blob/master/screenCapture/operate.gif)