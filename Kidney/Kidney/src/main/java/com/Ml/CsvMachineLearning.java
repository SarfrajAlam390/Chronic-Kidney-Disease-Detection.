package com.Ml;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.classifiers.trees.J48; // J48 is Weka's implementation of the C4.5 algorithm
import weka.classifiers.Evaluation;
import weka.classifiers.Classifier;
import weka.core.SerializationHelper;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CsvMachineLearning {
	
	public static void main(String[] args) {
        try {
            // Step 1: Load CSV file
            CSVLoader loader = new CSVLoader();
            File file = new File("C:\\Users\\vertijava\\Desktop\\Kidney_data.csv"); // Replace with your CSV file path
            
            System.out.println("Loading file: " + file.getAbsolutePath());
            
            loader.setSource(file);
            
            // Handle the potential header row if present
            //loader.setNoHeaderRowPresent(true); // Set to true if the CSV has no header row, false otherwise

            // Try-catch block for catching CSV loading issues
            Instances data = null;
            try {
                data = loader.getDataSet();
            } catch (IOException e) {
                System.out.println("Error reading CSV file: " + e.getMessage());
                e.printStackTrace();
                return;
            }
            
            if (data == null) {
                System.out.println("Error: Data is null after loading CSV.");
                return;
            }

            // Step 2: Set class index (the target variable or label)
            data.setClassIndex(data.numAttributes() - 1); // Assuming the last column is the target class

            // Step 3: Split the data into training and testing sets
            int trainSize = (int) Math.round(data.numInstances() * 0.8);
            int testSize = data.numInstances() - trainSize;
            Instances trainData = new Instances(data, 0, trainSize);
            Instances testData = new Instances(data, trainSize, testSize);

            // Step 4: Create and train a classifier (using J48 as an example)
            Classifier classifier = new J48(); // You can choose other algorithms like SVM, Random Forest, etc.
            classifier.buildClassifier(trainData);

            // Step 5: Evaluate the model
            Evaluation evaluation = new Evaluation(trainData);
            evaluation.evaluateModel(classifier, testData);

            // Step 6: Output the results
            System.out.println(evaluation.toSummaryString());

            // Step 7: Save the trained model (optional)
            SerializationHelper.write("model.model", classifier);

        } catch (Exception e) {
            // Catching general exception and printing stack trace for debugging
            e.printStackTrace();
        }
    }

}
