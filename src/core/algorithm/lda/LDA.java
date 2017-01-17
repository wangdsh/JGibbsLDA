package core.algorithm.lda;


public class LDA implements Runnable{

    @Override
    public void run() {
        LDAOption option = new LDAOption();
        
        option.dir = "D:/d12/model"; //数据结果（模型数据）保存位置
        option.dfile = "doc.dat"; //训练数据或原始数据文件名
        option.est = true; //是否开始训练模型
        ///option.estc = true;
        option.inf = false; //是否使用先前已经训练好的模型进行推断
        option.modelName = "model-final";
        option.niters = 1000; //迭代数目，谨慎设置
        Estimator estimator = new Estimator();
        estimator.init(option);
        estimator.estimate();
    }

    public static void main(String[] args) {
        new LDA().run();
    }
    
}
