import com.wm.utils.newClass 

def call(String name){
    def buildUtils
    buildUtils = new newClass()
    echo buildUtils.greet(name)

    def request = libraryResource 'example/test/sample.txt'
    echo "$request"
}


