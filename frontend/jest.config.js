module.exports = {
    // Indicates whether each individual test should be reported during the run
    verbose: true,
  
    // Automatically clear mock calls and instances between every test
    clearMocks: true,
  
    // The directory where Jest should output its coverage files
    coverageDirectory: "coverage",
  
    // An array of file extensions your modules use
    moduleFileExtensions: ['js', 'json', 'jsx', 'ts', 'tsx', 'node'],
  
    // The test environment that will be used for testing
    testEnvironment: "node",
  
    // The glob patterns Jest uses to detect test files
    testMatch: [
      "**/__tests__/**/*.[jt]s?(x)",
      "**/?(*.)+(spec|test).[tj]s?(x)"
    ],
  
    // Reporters configuration for outputting test results
    reporters: [
      "default",
      [
        "jest-junit", {
          outputDirectory: "./",
          outputName: "output-frontend.xml"
        }
      ]
    ]
  };
  