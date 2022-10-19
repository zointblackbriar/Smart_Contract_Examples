
interface SampleInterface {
    void showResult(int sampleParam1, int sampleParam2);
}

public class SampleClass : SampleInterface
{
    public string myField = string.Empty; 

    public SampleClass() {

    }

    public void showResult(int sampleParam1, int sampleParam2) {
        Console.WriteLine("sampleParam1 : {0} and sampleParam2: {1}", sampleParam1, sampleParam2); 

    }
}

