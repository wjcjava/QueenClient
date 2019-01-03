package com.ainisi.queenmirror.queenmirrorcduan.ui.order.bean;

import java.util.List;

/**
 * Created by john on 2018/5/12.
 */

public class RefundBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"apiRefundList":[{"refundId":"059187b38f364f458661e64fffc5466b","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"065a4e3e88a247259f8298bb13dd7977","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"2469d5ad67394c2ab3d02003e1de3fe0","orderId":"92ee703bfdb5494392d8a8afb3ee1acc","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"老干妈风味鸡油辣","purchaseNumber":"1"}]},{"refundId":"272a24b2a3b94b5e8f747b38fccd7a23","orderId":"7f04259df1f54061a455522d5eddfd73","shopId":"b4129d89efa44d069c656b26fec16499","shopName":"贾氏集团","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262617889894.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618081219.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618296528.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618330133.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618421218.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"贾氏辣条","purchaseNumber":"1"},{"goodsName":"贾氏火腿肠","purchaseNumber":"1"}]},{"refundId":"2d1b01379773490c9175dbae67e88591","orderId":"97b55f8fdf3c4eac8cec7dc03b57cd42","shopId":"b4129d89efa44d069c656b26fec16499","shopName":"贾氏集团","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262617889894.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618081219.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618296528.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618330133.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618421218.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"贾氏火腿肠","purchaseNumber":"1"}]},{"refundId":"2e9a19f54d14467f8dd0fa502349bd85","orderId":"6aaef3968fb94c91bfa2f87c8fe5b5dc","shopId":"b4129d89efa44d069c656b26fec16499","shopName":"贾氏集团","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262617889894.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618081219.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618296528.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618330133.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618421218.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"贾氏辣条","purchaseNumber":"1"}]},{"refundId":"2eb9a108c1044b3ea3cb46ac30f4ac1a","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"3d4daea44c5e43b5b56e4afa5c51fd96","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"43704239f0254cf7b00590df3080ff82","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"48e801cd1a0b48e9932ebdc9a6b408a3","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"49034063d66445cab2ed35a20ffd5b18","orderId":"a0198788a58848e6b92a9fec1ec37642","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"2"}]},{"refundId":"49c131d8525b43b3bf1358cf5a2994c9","orderId":"4c64aaaf43084419a1715c622ff5ec29","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"测试","purchaseNumber":"1"}]},{"refundId":"4cd5f9b82a014887b8329c1598a32b29","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"4fd73f3a8bbd48abaca79200f8224936","orderId":"7875bdbaeec84b48a05f3f4640ff4637","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"2"}]},{"refundId":"5219b5335dbc4efca2647ba41d1442d7","orderId":"4bcd870d22fe4c50b3b4c1814fb617a7","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"},{"goodsName":"老干妈风味鸡油辣","purchaseNumber":"1"},{"goodsName":"奥利奥夹心饼干","purchaseNumber":"2"}]},{"refundId":"53357284a75b46209e4404827e432410","orderId":"b0484ebc500d4c0883e377639bf91248","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"57831101e966449aa40961d7729e7796","orderId":"ae7b1485ac3547528bc5ba91e154ec85","shopId":"b4129d89efa44d069c656b26fec16499","shopName":"贾氏集团","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262617889894.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618081219.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618296528.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618330133.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618421218.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"贾氏火腿肠","purchaseNumber":"1"},{"goodsName":"老干妈风味鸡油辣","purchaseNumber":"1"}]},{"refundId":"5a34f28698164df9b13eb50c4da227d7","orderId":"ae7b1485ac3547528bc5ba91e154ec85","shopId":"b4129d89efa44d069c656b26fec16499","shopName":"贾氏集团","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262617889894.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618081219.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618296528.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618330133.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618421218.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"贾氏火腿肠","purchaseNumber":"1"},{"goodsName":"老干妈风味鸡油辣","purchaseNumber":"1"}]},{"refundId":"6ce1c3ea95ca4b8d8120b96e4242e808","orderId":"f7ce056d2cf54ffd9f20a0625faac9a7","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"小米手机","purchaseNumber":"1"}]},{"refundId":"73cc27d347264b6fb36927cbf4fece4c","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"7e3d63f0d62c42c1978736e93be07317","orderId":"e1c9a5f91a64437793c61fcc8be5e4cb","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"9号平衡车","purchaseNumber":"1"}]},{"refundId":"8104e06fff124312a784453af4905587","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"8368bc287df94db29946678f1dd1a561","orderId":"f3190ff51f624069bcd0d841269f287a","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"美少女战士","purchaseNumber":"1"}]},{"refundId":"883c451b2aa14879a7f115098dfd7302","orderId":"9483c5a4ac354591ba14664a6d8f7060","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"iPhone X","purchaseNumber":"1"}]},{"refundId":"9d7f7ee118f146e88b6215e6c45ed510","orderId":"9ee44edbecae43859b88348eb480b920","shopId":"50ffa507166b4c019525e3700a31a441","shopName":"霉霉的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802185914823745.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"空白格","purchaseNumber":"1"}]},{"refundId":"a8a9b4ace2234adab8d7c015110977cf","orderId":"4a55eb3970a94859a0e7cd754cd199e7","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"部分已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"贾氏火腿肠","purchaseNumber":"1"},{"goodsName":"老干妈风味鸡油辣","purchaseNumber":"1"}]},{"refundId":"ae3e7bb4dd5d44c6883351f33add2a9f","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"b1c8b38dfa7a4529935198041e70eff9","orderId":"510aaf34c77e496497a513f8c87582cc","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"狗头","purchaseNumber":"1"}]},{"refundId":"b263cb629ef94b08aaf14facb82bc2ac","orderId":"75fdf211cbc34a44b1047b225ac4bac2","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"老干妈风味鸡油辣","purchaseNumber":"1"}]},{"refundId":"b6012f310fce44ea9059ff1dc0b6c7c1","orderId":"4bcd870d22fe4c50b3b4c1814fb617a7","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"},{"goodsName":"老干妈风味鸡油辣","purchaseNumber":"1"},{"goodsName":"奥利奥夹心饼干","purchaseNumber":"2"}]},{"refundId":"c65e4acf64984048954c66203432372c","orderId":"0a89168e46d142a9afe3d0fda2d720b5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"cf3283fcdabd4c82b3388d85aa37fa33","orderId":"c118771789eb4bbe9259aa30a9d28948","shopId":"fb252e4bb6b54161957bbd756c6a1db3","shopName":"ABC&DEF的小店","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802532653027479.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802532653244331.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802532653567893.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"B商品","purchaseNumber":"1"}]},{"refundId":"d2f794f87e4043828b3d4113b0f0f492","orderId":"6a322b482a544b81aa35e946db110295","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"美少女战士","purchaseNumber":"1"}]},{"refundId":"d9a1607baf9a43b3ba9c0cfd24b7a423","orderId":"6aaef3968fb94c91bfa2f87c8fe5b5dc","shopId":"b4129d89efa44d069c656b26fec16499","shopName":"贾氏集团","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262617889894.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618081219.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618296528.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618330133.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618421218.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"贾氏辣条","purchaseNumber":"1"}]},{"refundId":"ddaa4b73a91c4f7eb7cbd52bebf15f99","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"e669671effe9429a8363fe4d7fc899f5","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"ee78a6467e194f2383f445280f3d3400","orderId":"8086f68f10c1441597f034bd8f3bc1d5","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"eef3654563b9403d9f7d27fb83347edc","orderId":"91b7dec6f46b49c3b4357a2e80531887","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"老干妈风味鸡油辣","purchaseNumber":"1"}]},{"refundId":"f018cca1d4e3486786194897b5747708","orderId":"714ffdbd2fae4185a20f18cc3643fdc2","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"f112532b68414cceb701b07fd13abd57","orderId":"b6a69b6212a240518b53062ef74c10f2","shopId":"282d19687335493195cebd824fb282d2","shopName":"WZADH","orderStatus":"退款中","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/201806300625002547516.jpg","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"单色美甲","purchaseNumber":"1"}]},{"refundId":"f54bb934d3dd43289c56826cb0aef652","orderId":"4bcd870d22fe4c50b3b4c1814fb617a7","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"},{"goodsName":"老干妈风味鸡油辣","purchaseNumber":"1"},{"goodsName":"奥利奥夹心饼干","purchaseNumber":"2"}]},{"refundId":"f8afa6f21b314bf8bcf1da20b6912038","orderId":"7f04259df1f54061a455522d5eddfd73","shopId":"b4129d89efa44d069c656b26fec16499","shopName":"贾氏集团","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262617889894.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618081219.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618296528.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618330133.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618421218.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"贾氏辣条","purchaseNumber":"1"},{"goodsName":"贾氏火腿肠","purchaseNumber":"1"}]},{"refundId":"f93718b4929a480ca40895a2aeb3ddbd","orderId":"cb3d65e3487446d8a8a6d7e9cfa5a611","shopId":"fb252e4bb6b54161957bbd756c6a1db3","shopName":"ABC&DEF的小店","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802532653027479.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802532653244331.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802532653567893.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"B商品","purchaseNumber":"1"}]},{"refundId":"fb87b933188142ce94758f36b1ff98f9","orderId":"4a55eb3970a94859a0e7cd754cd199e7","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"部分已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"贾氏火腿肠","purchaseNumber":"1"},{"goodsName":"老干妈风味鸡油辣","purchaseNumber":"1"}]},{"refundId":"fee3f94d23d34b6d8464418f6ff4feab","orderId":"99a495acd3c54312bc1d769a04c74346","shopId":"97f6494cad0f4c8e9c0dfb62d1f9f50a","shopName":"姜超的店铺","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"叫了个鸡","purchaseNumber":"1"}]},{"refundId":"ff3b23af0e8d408ba7ac931d468a57de","orderId":"4d39bc3931754d27b6d3b65cc9e44230","shopId":"b4129d89efa44d069c656b26fec16499","shopName":"贾氏集团","orderStatus":"已退款","shopLogo":"https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262617889894.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618081219.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618296528.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618330133.jpg,https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802262618421218.jpg,","afterAmount":null,"apiRefundGoodsList":[{"goodsName":"贾氏火腿肠","purchaseNumber":"1"}]}]}
     */

    private boolean success;
    private String errorCode;
    private String msg;
    private BodyBean body;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        private List<ApiRefundListBean> apiRefundList;

        public List<ApiRefundListBean> getApiRefundList() {
            return apiRefundList;
        }

        public void setApiRefundList(List<ApiRefundListBean> apiRefundList) {
            this.apiRefundList = apiRefundList;
        }

        public static class ApiRefundListBean {
            /**
             * refundId : 059187b38f364f458661e64fffc5466b
             * orderId : 8086f68f10c1441597f034bd8f3bc1d5
             * shopId : 97f6494cad0f4c8e9c0dfb62d1f9f50a
             * shopName : 姜超的店铺
             * orderStatus : 退款中
             * shopLogo : https://nwptest.oss-cn-hangzhou.aliyuncs.com/2018062802165260426383.jpg,
             * afterAmount : null
             * apiRefundGoodsList : [{"goodsName":"叫了个鸡","purchaseNumber":"1"}]
             */

            private String refundId;
            private String orderId;
            private String shopId;
            private String shopName;
            private String orderStatus;
            private String shopLogo;
            private String afterAmount;
            private List<ApiRefundGoodsListBean> apiRefundGoodsList;

            public String getRefundId() {
                return refundId;
            }

            public void setRefundId(String refundId) {
                this.refundId = refundId;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getShopId() {
                return shopId;
            }

            public void setShopId(String shopId) {
                this.shopId = shopId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(String orderStatus) {
                this.orderStatus = orderStatus;
            }

            public String getShopLogo() {
                return shopLogo;
            }

            public void setShopLogo(String shopLogo) {
                this.shopLogo = shopLogo;
            }

            public String getAfterAmount() {
                return afterAmount;
            }

            public void setAfterAmount(String afterAmount) {
                this.afterAmount = afterAmount;
            }

            public List<ApiRefundGoodsListBean> getApiRefundGoodsList() {
                return apiRefundGoodsList;
            }

            public void setApiRefundGoodsList(List<ApiRefundGoodsListBean> apiRefundGoodsList) {
                this.apiRefundGoodsList = apiRefundGoodsList;
            }

            public static class ApiRefundGoodsListBean {
                /**
                 * goodsName : 叫了个鸡
                 * purchaseNumber : 1
                 */

                private String goodsName;
                private String purchaseNumber;

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public String getPurchaseNumber() {
                    return purchaseNumber;
                }

                public void setPurchaseNumber(String purchaseNumber) {
                    this.purchaseNumber = purchaseNumber;
                }
            }
        }
    }
}
