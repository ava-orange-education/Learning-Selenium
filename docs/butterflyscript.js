(function($) {

    var $body = $('body');
    var items = [];
    var ox=$(document).width()/2, oy=$(document).height()/2;

    // vendor prefix ?
    var prefix = getVendorPrefix();
    function getVendorPrefix()
    {
        var el = document.createElement('div'),
            prefix = '';
    
        if ('WebkitTransition' in el.style) prefix='-webkit-';
        else if ('MozTransition' in el.style) prefix='-moz-';
        return prefix;
    }

    function Nabi(type) {
        this.$elt = $('<div class="nabpi n'+type+'"><div class="left wing"></div><div class="body"></div><div class="right wing"></div></div');
        this.elt = this.$elt[0];
        this.$wings = this.$elt.find('.wing');

        this.scale = Math.random()*0.5+0.1;
        this.$wings.css('animation-duration', (this.scale*2)+'s');

        this.x = Math.random()*$(document).width();//p.left;
        this.y = Math.random()*$(document).height();//p.top;
        this.vx = Math.random()*10-5;
        this.vy = Math.random()*10-5;
        this.l = this.scale*20;
this.z = Math.round(-1/this.scale*2500);
        this.move();
    }
    Nabi.prototype.move = function() {
        // calcul angle
        var r = Math.sqrt(this.vx*this.vx + this.vy*this.vy),
            cos = this.vx / r,
            angle = Math.acos(cos) * 180 / Math.PI + 90,
            transform = 'perspective(4000px) translateZ('+this.z+'px) '; //'scale('+this.scale+') ';

        if (this.vy < 0)
            angle = 180 - angle;
        transform += 'rotateZ(' + Math.round(angle) + 'deg)';
    
        this.x+= this.vx;
        this.y+= this.vy;
        
        var cssText = '';
        cssText+= prefix+'transform:'+transform+';';
        cssText+= 'left:'+Math.round(this.x)+'px;';
        cssText+= 'top:'+Math.round(this.y)+'px;';
        this.elt.style.cssText = cssText;
        return this;
    };
    Nabi.prototype.setDestination = function(ox, oy) {
        var dx = ox - this.x,
            dy = oy - this.y,
            d = Math.sqrt(dx*dx + dy*dy);

        this.vx = this.vx + 0.4*dx/d;
        this.vy = this.vy + 0.4*dy/d;
        this.limit().move();
        return this;
    };

    Nabi.prototype.limit = function() {
        var l = this.l;
        if (this.vx>l) this.vx=l;
        else if (this.vx<-l) this.vx=-l;
        if (this.vy>l) this.vy=l;
        else if (this.vy<-l) this.vy=-l;
        return this;
    };
    
    function update() {
        for (var i = 0; i < items.length; i++) {
            items[i].setDestination(ox, oy);
        }
    }

    $(document).ready(function(){
        
        var $container = $('#container');
        
        for (var i=0;i<25;i++)
        {
            var nabi=new Nabi((i%3+1));
            $container.append(nabi.$elt);
            items.push(nabi);
        }
        
        $(document).on('mousemove', function(e){
            ox = e.clientX;
            oy = e.clientY;
        });
        
        $(document).on('click', function(e){
            for (var i = 0; i < items.length; i++) {
                items[i].vx = 40-Math.random()*80;
                items[i].vy = 40-Math.random()*80;
            }
        });

        setInterval(function(){
            update();
        }, 1000/25);

    });
    
})(jQuery);