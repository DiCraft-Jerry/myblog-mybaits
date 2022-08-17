package cn.dicraft.myblog.service.impl;

import cn.dicraft.myblog.dao.BlogDao;
import cn.dicraft.myblog.entity.Blog;
import cn.dicraft.myblog.exception.NotFoundException;
import cn.dicraft.myblog.queryVo.*;
import cn.dicraft.myblog.service.BlogService;
import cn.dicraft.myblog.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 13:32
 * @package: cn.dicraft.myblog.service.impl
 * @Version: 1.0
 * @Decsription: 博客列表业务层接口实现类
 */
@Service
public class BlogServiceImpl implements BlogService {


    @Autowired
    private BlogDao blogDao;

    /**
     * 保存新增博客
     *
     * @param blog
     * @return
     */
    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogDao.saveBlog(blog);
    }

    /**
     * 查询文章管理列表
     *
     * @return
     */
    @Override
    public List<BlogQuery> getAllBlogQuery() {
        return blogDao.getAllBlogQuery();
    }

    /**
     * 删除博客
     *
     * @param id
     */
    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteBlog(id);
    }

    /**
     * 编辑博客
     *
     * @param showBlog
     * @return
     */
    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogDao.updateBlog(showBlog);
    }

    /**
     * 查询编辑修改的文章
     *
     * @param id
     * @return
     */
    @Override
    public ShowBlog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }

    /**
     * 搜索博客管理列表
     *
     * @param searchBlog
     * @return
     */
    @Override
    public List<BlogQuery> getBlogBySearch(SearchBlog searchBlog) {
        return blogDao.searchByTitleAndType(searchBlog);
    }


    @Override
//    @Cacheable(value = "blogList",key = "'blog'")       // redis缓存
    /**
     * 查询首页最新博客列表信息
     * 这里不能使用缓存技术，否则前端页面展示时会导致的分页不显示的问题
     * @return
     */
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogDao.getFirstPageBlog();
    }

    /**
     * 查询首页最新推荐信息
     * 这里不能使用缓存技术，否则前端页面展示时会导致的分页不显示的问题
     * @return
     */
    @Override
//    @Cacheable(value = "commentblogList",key = "'commentblog'")
    public List<RecommendBlog> getRecommendedBlog() {
        List<RecommendBlog> allRecommendBlog = blogDao.getAllRecommendBlog();
        return allRecommendBlog;
    }

    /**
     * 搜索博客列表
     *
     * @param query
     * @return
     */
    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return blogDao.getSearchBlog(query);
    }

    /**
     * 统计博客总数
     *
     * @return
     */
    @Override
    public Integer getBlogTotal() {
        return blogDao.getBlogTotal();
    }

    /**
     * 统计访问总数
     *
     * @return
     */
    @Override
    public Integer getBlogViewTotal() {
        return blogDao.getBlogViewTotal();
    }

    /**
     * 统计评论总数
     *
     * @return
     */
    @Override
    public Integer getBlogCommentTotal() {
        return blogDao.getBlogCommentTotal();
    }

    /**
     * 统计留言总数
     *
     * @return
     */
    @Override
    public Integer getBlogMessageTotal() {
        return blogDao.getBlogMessageTotal();
    }

    /**
     * 查询博客详情
     *
     * @param id
     * @return
     */
    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        DetailedBlog detailedBlog = blogDao.getDetailedBlog(id);
        if (detailedBlog == null) {
            throw new NotFoundException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        //文章访问数量自增
        blogDao.updateViews(id);
        //文章评论数量更新
        blogDao.getCommentCountById(id);
        return detailedBlog;
    }

    /**
     * 根据TypeId查询博客列表，显示在分类页面
     *
     * @param typeId
     * @return
     */
    @Override
    public List<FirstPageBlog> getByTypeId(Long typeId) {
        return blogDao.getByTypeId(typeId);
    }

    /**
     * 查询最新评论
     *
     * @return
     */
    @Override
    @Cacheable(value = "NewCommentList",key = "'NewComment'")
    public List<NewComment> getNewComment() {
        return blogDao.getNewComment();
    }
}
