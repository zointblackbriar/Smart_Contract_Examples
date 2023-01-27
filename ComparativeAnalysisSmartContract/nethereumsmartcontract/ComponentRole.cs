namespace Demo {
    interface Component {
        void sampleBehaviorA(); 
        void sampleBehaviorB(); 
    }

    class ComponentRole : Component {
        public void sampleBehaviorA() {
            Console.WriteLine("ComponentRole is talking - sampleBehaviorA"); 
        }

        public void sampleBehaviorB() {
            Console.WriteLine("ComponentRole is talking - sampleBehaviorB");
        }
    }

    class ComponentCore : Component {
        public void sampleBehaviorA() {
            Console.WriteLine("ComponentCore is talking - sampleBehaviorA"); 
        }

        public void sampleBehaviorB() {
            Console.WriteLine("ComponentCore is talking - sampleBehaviorB");
        }
    }
}

