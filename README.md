# Java版本的LDA(Latent Dirichlet Allocation)实现、修改及使用
* 概述
* 参数说明和设置
* 输入数据格式
* 输出数据

## 概述
LDA是一种由基于概率模型的聚类算法。该算法能够对训练数据（训练数据是这样一种记录的集合，它的每一条记录都是一组离散的项的集合）中的关键项集之于类簇的概率参数拟合模型，进而利用该参数模型实施聚类或分类等操作。

## 参数说明和设置
//Specify whether we want to estimate modelfrom scratch<br>
boolean est= false;  /////是否开始训练模型<br>
//Specify whether we want to continue thelast estimation<br>
决定是否是基于先前已有的模型基础上继续用新数据训练模型<br>
boolean estc= false;<br>
boolean inf= true;    /////是否使用先前已经训练好的模型进行推断<br>
String dir= "";  //Specify directory  ////数据结果（模型数据）保存位置<br>
String dfile= "";  //Specify resource data filename    /////训练数据或原始数据文件名<br>
//Specify the model level to which you wantto applied. ///<br>
String modelName= "";  ////选择使用哪一个迭代的模型结果来进行推断<br>
int K= 100;  //Specify the number of topics  /////类簇数目，谨慎设置<br>
double alpha= 0.2;  //Specify alpha //////平滑系数<br>
double beta= 0.1;  //Specify beta<br>
int niters= 1000;  //Specify the number of iterations  /////迭代数目，谨慎设置<br>
//Specify the number of steps to save themodel since the last save.<br>
//The step (counted by the number ofGibbssampling iterations)<br>
//at which the LDA model is saved to harddisk.<br>
//指定把迭代结果模型保存到硬盘上的迭代跨度，即每迭代10次保存一次。<br>
int savestep= 100;<br>
//Specify the number of most likely wordsto be printed for each topic<br>
int twords= 100;   /////对每一个类别（话题）选前多少个最大概率词项<br>
//Specify whether we include raw data in theinput<br>
public boolean withrawdata= false; <br>
//Specify thewordmapfile<br>
publicString wordMapFileName= "wordmap.txt";  /////生成的副产品的文件名<br>

# 原文链接
http://blog.csdn.net/memray/article/details/16810763