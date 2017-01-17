# Java版本的LDA(Latent Dirichlet Allocation)实现、修改及使用
* 概述
* 参数说明和设置
* 输入数据格式
* 输出数据

## 概述
LDA是一种由基于概率模型的聚类算法。该算法能够对训练数据（训练数据是这样一种记录的集合，它的每一条记录都是一组离散的项的集合）中的关键项集之于类簇的概率参数拟合模型，进而利用该参数模型实施聚类或分类等操作。

## 参数说明和设置
//Specify whether we want to estimate modelfrom scratch<br>
boolean est= false;  //是否开始训练模型<br>

//Specify whether we want to continue thelast estimation<br>
决定是否是基于先前已有的模型基础上继续用新数据训练模型<br>
boolean estc= false;<br>

boolean inf= true;  //是否使用先前已经训练好的模型进行推断<br>

String dir= "";  //Specify directory //数据结果（模型数据）保存位置<br>

String dfile= "";  //Specify resource data filename  //训练数据或原始数据文件名<br>

//Specify the model level to which you wantto applied. ///<br>
String modelName= "";  //选择使用哪一个迭代的模型结果来进行推断<br>

int K= 100;  //Specify the number of topics //类簇数目，谨慎设置<br>

double alpha= 0.2;  //Specify alpha //平滑系数<br>

double beta= 0.1;  //Specify beta<br>

int niters= 1000;  //Specify the number of iterations  //迭代数目，谨慎设置<br>

//Specify the number of steps to save themodel since the last save.<br>
//The step (counted by the number ofGibbssampling iterations)<br>
//at which the LDA model is saved to harddisk.<br>
//指定把迭代结果模型保存到硬盘上的迭代跨度，即每迭代10次保存一次。<br>
int savestep= 100;<br>

//Specify the number of most likely wordsto be printed for each topic<br>
int twords= 100;  //对每一个类别（话题）选前多少个最大概率词项<br>

//Specify whether we include raw data in theinput<br>
public boolean withrawdata= false; <br>

//Specify thewordmapfile<br>
publicString wordMapFileName= "wordmap.txt";  //生成的副产品的文件名<br>

## 输入数据格式
数据输入格式统一如下所述：<br>
[M]  
[document1]  
[document2]  
...  
[documentM]  
其中：  
第一行为该数据文件有多少条记录数。然后每一行记录按行排列。  
这里的“记录”的格式又规定为：  
[documenti]= [wordi1] [wordi2] ... [wordiNi]  
其中：[wordiNi]为[documenti]的各个词项，以空格分隔。  
众所周知，对词项集合进行预处理，如去除停用词、主干提取等，对结果精度的提升有较大帮助。(本代码未做此工作)  

## 输出数据
建立模型阶段，会输出5类以如下规则命名的文件类型：  
model-XXXXX.others:  
model-XXXXX.phi  
model-XXXXX.theta  
model-XXXXX.tassign  
model-XXXXX.twords  
XXXXX都以数字组成。最后一次迭代所保存的这些数字将会换成“final”。  

其中：  
**.others为“信息文件”。**文件保存的是跟该LDA模型有关的参数，比如alpha，beta，ntopiccs，ndocs，nwords，liter（the Gibbssampling iteration at which the model was saved）<br>
**.phi文件为“词项-主题概率分布文件”。**表现上是一个大矩阵M。其中，假设设类簇的数目topict为1000个，每一个主题需要列出top 100个词项wordw，则M以100为行，1000为列。即M每一行是词项，每一列是主题。M元素值则为条件概率p(wordw|topict)，即每个词属于每个主题的概率。<br>
**.theta文件为“文档-主题概率分布文件”。**表现上也是一个大矩阵M。每行i代表训练数据的一个文档，每一列代表一个主题，元素值则为条件概率 p(topict|documentm)，即该文档属于不同主题的概率。
**.tassign文件为“文档-词项-主题分布文件”。**该文件与输入文件的格式一致，一行一个文档，只不过原来的输入文件中的词项换成了一个一个“词项ID：类别”。文件每一行代表训练数据的一条文档，原文档由一组词项组成，现每一行为原来的记录词项指派了其最大可能的所属主题。注意，该文档所属主题分布是在theta文件中，并未在tassign文件中指明。<br>
**.twords文件为“词项-主题推断文件”。**这个文件作为模型参数结果推断出了每一个主题下最优的topN个词项及其概率。请注意这里的主题数和N都是事先指定的。<br>
这5个文件包括副产品wordmap.txt在有些应用场景下有时并不是完全需要的，是否生成可视情况而定。如果利用主题下topN词项来做基于距离的聚类，可能只需.twords即可。  

# 原文链接
http://blog.csdn.net/memray/article/details/16810763