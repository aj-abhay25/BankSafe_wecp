exports.config = {
    // ...
    framework: 'jasmine',
    jasmineNodeOpts: {
      showColors: true,
      defaultTimeoutInterval: 30000
    },
    specs: [
        "src/**/*.spec.ts"
    ]
  };