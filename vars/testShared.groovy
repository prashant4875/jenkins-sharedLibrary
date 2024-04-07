import com.wm.utils.newClass 

def call(String name){
    def buildUtils
    buildUtils = new newClass()
    buildUtils.MyFunctions.greet(name)

    def request = libraryResource 'example/test/sample.txt'
    echo "$request"
}


