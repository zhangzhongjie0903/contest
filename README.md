# 编程竞赛题目
本试题提供了javasript+mocha技术栈的版本和java+junit的版本，参赛人员可以选择自己熟悉的一种技术栈进行编码。

## 参赛人员须知
1. 笔记本电脑能连外网
2. 使用自己熟悉的IDE编程
3. 准备好自己的GitHub代码库，保存本次竞赛的代码
4. `git clone https://github.com/bibobibo/contest.git` 下载比赛题目

### 前端
5. 确保已经安装了nodejs v8.12.0以上的版本
6. `cd ./contest/js-mocha` 进入javascript版本的代码库
7. `npm run test` 运行测试，验证功能

## 后端
5. 确认已安装JDK 1.8和Maven 3.5.2以上版本
6. `cd ./contest/Java` 进入Java版本的代码库
7. `mvn clean test` 运行测试，验证功能

## 题目描述

### 中文版
欢迎来到镶金玫瑰(Gilded Rose)团队。如你所知，我们是城中的一个小旅店，店主非常友好。我们也售卖最好的商品。不过，很多商品品质会随着销售期限的接近而不断下降。
请帮助我们开发一个系统，能每日更新每种库存商品的品质和销售期。

先介绍一下商品品质和销售期的计算方法：

	- 每种商品都具备一个销售期（`SellIn`），表示我们要在多少天之内把商品卖出去；
	- 每种商品都具备一个品质值（`Quality`），表示商品所具备的品质；
	- 每天结束时，系统会将每种商品的这两个数值减1。

很简单吧？下面的计算方法更有意思：

	- 一旦销售期限过期，品质值`Quality`会每天减2；
	- 商品的品质`Quality`永远不会为负值；
	- "Aged Brie"（法国干酪）的品质`Quality`会每天增1；
	- 商品的品质`Quality`永远不会超过50；
	- 传奇商品"Sulfuras"（游戏中的魔法锤道具）永不到期，也不会降低品质`Quality`；
	- "Backstage passes"（剧场后台通行证）与aged brie类似，其品质`Quality`在剧场开演前10天以外，每天增1；当离开演不足10天（含10天）时，品质`Quality`每天增2；当离开演不足5天（含5天）时，品质`Quality`每天增3；但一旦演出结束，品质就会降为0。

请不要修改Item类或其属性。

再次澄清，每种商品的品质不会超过50，然而"Sulfuras"是一个传奇商品，因此它的品质是80且永远不变。

### 英文版
Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a
prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods.
Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. Please help us
to develop a system that updates our inventory for us. First an introduction to our system:

	- All items have a SellIn value which denotes the number of days we have to sell the item
	- All items have a Quality value which denotes how valuable the item is
	- At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

	- Once the sell by date has passed, Quality degrades twice as fast
	- The Quality of an item is never negative
	- "Aged Brie" actually increases in Quality the older it gets
	- The Quality of an item is never more than 50
	- "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	Quality drops to 0 after the concert

Please do not alter the Item class or Items property.

Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
legendary item and as such its Quality is 80 and it never alters.

