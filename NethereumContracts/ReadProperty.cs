using System;
using System.IO;
using System.Collections.Generic;
using Authlete.Util;

namespace PropertySpace {

    class ReadProperty {
        public static void readerProperty() {
            string file = "test.properties"; 
            IDictionary<string, string> properties; 
            using (TextReader reader = new StreamReader(file)) 
            {
                properties = PropertyLoader.Load(reader); 
            }

            foreach (var entry in properties) {
                Console.WriteLine($"{entry.key} = {entry.Value}");
            }
        }
    }
}