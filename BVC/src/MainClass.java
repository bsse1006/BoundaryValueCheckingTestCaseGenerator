import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainClass
{
    public static void main(String[] args) throws IOException {
        Scanner cin = new Scanner(System.in);

        System.out.println("Enter number of parameters: ");

        int numberOfParamters = cin.nextInt();

        int [] min = new int[numberOfParamters];
        int [] max = new int[numberOfParamters];

        System.out.println("Enter min & max values: ");

        for(int i=0; i<numberOfParamters; i++)
        {
            min[i] = cin.nextInt();
            max[i] = cin.nextInt();
        }

        String bvc = "TestCaseID,";
        String robust = "TestCaseID,";
        String worstcase = "TestCaseID,";

        for(int i=0; i<numberOfParamters; i++)
        {
            bvc = bvc + "Parameter" + String.valueOf(i+1) + ",";
            robust = robust + "Parameter" + String.valueOf(i+1) + ",";
            worstcase = worstcase + "Parameter" + String.valueOf(i+1) + ",";
        }

        bvc = bvc + "ExpectedValue" + "\n";
        robust = robust + "ExpectedValue" + "\n";
        worstcase = worstcase + "ExpectedValue" + "\n";

        int [] [] bvcOutput = new int[numberOfParamters*4+1][numberOfParamters+1];

        int rowCount = 0;

        for (int i=0; i<numberOfParamters*4+1; i++)
        {
            bvcOutput[i][0] = i+1;
        }

        for (int i=0; i<numberOfParamters; i++)
        {
            for (int j=0; j<numberOfParamters; j++)
            {
                if(i==j)
                {
                    bvcOutput[rowCount][j+1] = min[j];
                }
                else
                {
                    bvcOutput[rowCount][j+1] = (min[j] + max[j])/2;
                }
            }

            rowCount++;

            for (int j=0; j<numberOfParamters; j++)
            {
                if(i==j)
                {
                    bvcOutput[rowCount][j+1] = max[j];
                }
                else
                {
                    bvcOutput[rowCount][j+1] = (min[j] + max[j])/2;
                }
            }

            rowCount++;

            for (int j=0; j<numberOfParamters; j++)
            {
                if(i==j)
                {
                    bvcOutput[rowCount][j+1] = min[j] + 1;
                }
                else
                {
                    bvcOutput[rowCount][j+1] = (min[j] + max[j])/2;
                }
            }

            rowCount++;

            for (int j=0; j<numberOfParamters; j++)
            {
                if(i==j)
                {
                    bvcOutput[rowCount][j+1] = max[j] - 1;
                }
                else
                {
                    bvcOutput[rowCount][j+1] = (min[j] + max[j])/2;
                }
            }

            rowCount++;
            /*bvcOutput[rowCount][0] = rowCount+1;
            bvcOutput[rowCount][1] = rowCount+1;
            bvcOutput[rowCount][2] = rowCount+1;
            bvcOutput[rowCount][3] = rowCount+1;*/
        }

        for (int j=0; j<numberOfParamters; j++)
        {
            bvcOutput[rowCount][j+1] = (min[j] + max[j])/2;
        }

        for (int i=0; i<numberOfParamters*4+1; i++)
        {
            for (int j=0; j<numberOfParamters+1; j++)
            {
                bvc = bvc + bvcOutput[i][j] + ",";
            }
            bvc = bvc.substring(0, bvc.length()-1);
            bvc = bvc + "\n";
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("files/BVC.csv")));
        writer.write(bvc);

        writer.close();


        int [] [] robustOutput = new int[numberOfParamters*6+1][numberOfParamters+1];

        rowCount = 0;

        for (int i=0; i<numberOfParamters*6+1; i++)
        {
            robustOutput[i][0] = i+1;
        }

        for (int i=0; i<numberOfParamters; i++)
        {
            for (int j=0; j<numberOfParamters; j++)
            {
                if(i==j)
                {
                    robustOutput[rowCount][j+1] = min[j];
                }
                else
                {
                    robustOutput[rowCount][j+1] = (min[j] + max[j])/2;
                }
            }

            rowCount++;

            for (int j=0; j<numberOfParamters; j++)
            {
                if(i==j)
                {
                    robustOutput[rowCount][j+1] = max[j];
                }
                else
                {
                    robustOutput[rowCount][j+1] = (min[j] + max[j])/2;
                }
            }

            rowCount++;

            for (int j=0; j<numberOfParamters; j++)
            {
                if(i==j)
                {
                    robustOutput[rowCount][j+1] = min[j] + 1;
                }
                else
                {
                    robustOutput[rowCount][j+1] = (min[j] + max[j])/2;
                }
            }

            rowCount++;

            for (int j=0; j<numberOfParamters; j++)
            {
                if(i==j)
                {
                    robustOutput[rowCount][j+1] = max[j] - 1;
                }
                else
                {
                    robustOutput[rowCount][j+1] = (min[j] + max[j])/2;
                }
            }

            rowCount++;

            for (int j=0; j<numberOfParamters; j++)
            {
                if(i==j)
                {
                    robustOutput[rowCount][j+1] = max[j] + 1;
                }
                else
                {
                    robustOutput[rowCount][j+1] = (min[j] + max[j])/2;
                }
            }

            rowCount++;

            for (int j=0; j<numberOfParamters; j++)
            {
                if(i==j)
                {
                    robustOutput[rowCount][j+1] = min[j] - 1;
                }
                else
                {
                    robustOutput[rowCount][j+1] = (min[j] + max[j])/2;
                }
            }

            rowCount++;
            /*bvcOutput[rowCount][0] = rowCount+1;
            bvcOutput[rowCount][1] = rowCount+1;
            bvcOutput[rowCount][2] = rowCount+1;
            bvcOutput[rowCount][3] = rowCount+1;*/
        }

        for (int j=0; j<numberOfParamters; j++)
        {
            robustOutput[rowCount][j+1] = (min[j] + max[j])/2;
        }

        for (int i=0; i<numberOfParamters*6+1; i++)
        {
            for (int j=0; j<numberOfParamters+1; j++)
            {
                robust = robust + robustOutput[i][j] + ",";
            }
            robust = robust.substring(0, robust.length()-1);
            robust = robust + "\n";
        }

        writer = new BufferedWriter(new FileWriter(new File("files/robust.csv")));
        writer.write(robust);

        writer.close();

        int values [][] = new int [5][numberOfParamters];

        for (int i=0; i < numberOfParamters; i++)
        {
            values[0][i] = min[i];
        }

        for (int i=0; i < numberOfParamters; i++)
        {
            values[1][i] = max[i];
        }

        for (int i=0; i < numberOfParamters; i++)
        {
            values[2][i] = min[i] + 1;
        }

        for (int i=0; i < numberOfParamters; i++)
        {
            values[3][i] = max[i] - 1;
        }

        for (int i=0; i < numberOfParamters; i++)
        {
            values[4][i] = (min[i] + max[i])/2;
        }

        int numberOfCases = (int) Math.pow(5,numberOfParamters);

        int [] [] worstOutput = new int[numberOfCases][numberOfParamters+1];

        for (int i=0; i<numberOfCases; i++)
        {
            worstOutput[i][0] = i+1;
        }

        for(int i=0; i < numberOfParamters; i++)
        {
            for (int j=0; j<numberOfCases; j++)
            {
                worstOutput[j][i+1] = values[(j/(int) Math.pow(5,i))%5][i];
            }
        }

        for (int i=0; i<numberOfCases; i++)
        {
            for (int j=0; j<numberOfParamters+1; j++)
            {
                worstcase = worstcase + worstOutput[i][j] + ",";
            }
            worstcase = worstcase.substring(0, worstcase.length()-1);
            worstcase = worstcase + "\n";
        }

        writer = new BufferedWriter(new FileWriter(new File("files/worst.csv")));
        writer.write(worstcase);

        writer.close();
    }
}